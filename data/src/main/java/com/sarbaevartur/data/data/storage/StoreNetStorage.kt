package com.sarbaevartur.data.data.storage

import android.content.Context
import com.sarbaevartur.data.data.remote.StoreApi
import com.sarbaevartur.data.data.remote.StoreApiHelperImpl
import com.sarbaevartur.data.data.storage.models.*
import kotlinx.coroutines.flow.Flow

private const val TAG = "NetStorage"

class StoreNetStorage(private val context: Context): StoreStorage {
    override suspend fun getCategories(): Flow<List<CategoryStorage>> {
        TODO("Not yet implemented")
    }

    override suspend fun getHotSales(): Flow<HotSaleStorage> {
        val apiHelper = StoreApiHelperImpl(StoreApi.RetrofitBuilder.apiService)
        return apiHelper.getHotSales()
    }

    override suspend fun getBestDeals(): Flow<BestDealsStorage> {
        val apiHelper = StoreApiHelperImpl(StoreApi.RetrofitBuilder.apiService)
        return apiHelper.getBestDeals()
    }

    override suspend fun getProductDetail(link: String): Flow<ProductStorage> {
        TODO("Not yet implemented")
    }

    override suspend fun getCart(): Flow<CartStorage> {
        val apiHelper = StoreApiHelperImpl(StoreApi.RetrofitBuilder.apiService)
        return apiHelper.getCart()
    }

    override fun loadImage(image: String?): LoadedImage {
        val loadedImage: LoadedImage = LoadedImage()
        return loadedImage
    }
}