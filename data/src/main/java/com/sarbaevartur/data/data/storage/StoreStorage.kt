package com.sarbaevartur.data.data.storage

import com.sarbaevartur.data.data.storage.models.*
import kotlinx.coroutines.flow.Flow

interface StoreStorage {

    suspend fun getCategories(): Flow<List<CategoryStorage>>

    suspend fun getHotSales(): Flow<HotSaleStorage>

    suspend fun getBestDeals(): Flow<BestDealsStorage>

    suspend fun getProductDetail(link: String): Flow<ProductStorage>

    suspend fun getCart(): Flow<CartStorage>

    fun loadImage(image: String?): LoadedImage?
}