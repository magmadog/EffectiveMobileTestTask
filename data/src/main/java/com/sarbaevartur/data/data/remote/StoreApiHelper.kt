package com.sarbaevartur.data.data.remote

import com.sarbaevartur.data.data.storage.models.BestDealsStorage
import com.sarbaevartur.data.data.storage.models.CartStorage
import com.sarbaevartur.data.data.storage.models.HotSaleStorage
import com.sarbaevartur.data.data.storage.models.ProductStorage
import kotlinx.coroutines.flow.Flow

interface StoreApiHelper {

    fun getHotSales(): Flow<HotSaleStorage>

    fun getBestDeals(): Flow<BestDealsStorage>

    fun getProductDetails(): Flow<ProductStorage>

    fun getCart(): Flow<CartStorage>
}