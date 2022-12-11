package com.sarbaevartur.domain.repository

import com.sarbaevartur.domain.models.*
import kotlinx.coroutines.flow.Flow

interface StoreRepository {

    suspend fun getCategories(): Flow<List<Category>>

    suspend fun getHotSales(): Flow<List<HotSale>>

    suspend fun getBestDeals(): Flow<List<BestDeal>>

    suspend fun getProductDetail(link: String): Flow<Product>

    suspend fun getCart(): Flow<Cart>
}