package com.sarbaevartur.data.data

import android.util.Log
import com.sarbaevartur.domain.repository.StoreRepository
import com.sarbaevartur.data.data.storage.StoreLocalStorage
import com.sarbaevartur.data.data.storage.StoreNetStorage
import com.sarbaevartur.data.data.storage.models.CartItemStorage
import com.sarbaevartur.data.data.storage.models.CartStorage
import com.sarbaevartur.domain.models.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

private const val TAG = "StoreRepository"

class StoreRepositoryImpl(val localStorage: StoreLocalStorage, val netStorage: StoreNetStorage): StoreRepository {
    override suspend fun getCategories(): Flow<List<Category>> =
        flow {
            emit(localStorage.getCategories().map {
                it.map {
                    Category(
                        it.category,
                        it.image
                    )
                }
            }.first())
        }

    override suspend fun getHotSales(): Flow<List<HotSale>> =
        flow {
            emit(netStorage.getHotSales().map {
                it.lst?.map {
                    HotSale(
                        is_new = it.isnew ?: false,
                        title = it.title ?: "",
                        subtitle = it.subtitle ?: "",
                        picture = it.picture ?: "",
                        is_buy = it.isbuy ?: false
                    )
                }
            }.first()!!)
        }

    override suspend fun getBestDeals(): Flow<List<BestDeal>>  =
        flow {
            emit(netStorage.getBestDeals().map {
                it.dealsList?.map {
                    BestDeal(
                        is_favourites = it.is_favourites,
                        title = it.title,
                        price_without_discount = it.price_without_discount,
                        discount_price = it.discount_price,
                        picture = it.picture,
                    )
                }
            }.first()!!)
        }

    override suspend fun getProductDetail(link: String): Flow<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun getCart(): Flow<Cart> =
        flow {
            emit(netStorage.getCart().map {
                Cart(
                    basket = it.basket.map { cartStorageItem ->
                        CartItem(
                            image = cartStorageItem.image,
                            price = cartStorageItem.price,
                            title = cartStorageItem.title) },
                    delivery = it.delivery,
                    total = it.total
                )
            }.first())
        }
}