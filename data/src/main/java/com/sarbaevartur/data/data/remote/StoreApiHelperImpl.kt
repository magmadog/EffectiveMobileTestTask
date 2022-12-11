package com.sarbaevartur.data.data.remote

import com.sarbaevartur.data.data.storage.models.BestDealsStorage
import com.sarbaevartur.data.data.storage.models.CartStorage
import com.sarbaevartur.data.data.storage.models.HotSaleStorage
import com.sarbaevartur.data.data.storage.models.ProductStorage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StoreApiHelperImpl(private val apiService: StoreApi): StoreApiHelper {

    override fun getHotSales(): Flow<HotSaleStorage> =
        flow {
            emit(apiService.getHotSales())
        }

    override fun getBestDeals(): Flow<BestDealsStorage> =
        flow {
            emit(apiService.getBestDeals())
        }

    override fun getProductDetails(): Flow<ProductStorage> =
        flow {
            emit(apiService.getProductDetails())
        }

    override fun getCart(): Flow<CartStorage> =
        flow {
            emit(apiService.getCart())
        }
}