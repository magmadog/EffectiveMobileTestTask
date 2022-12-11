package com.sarbaevartur.data.data.remote

import com.sarbaevartur.data.data.storage.models.BestDealsStorage
import com.sarbaevartur.data.data.storage.models.CartStorage
import com.sarbaevartur.data.data.storage.models.HotSaleStorage
import com.sarbaevartur.data.data.storage.models.ProductStorage
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val STORE_API = "https://run.mocky.io/v3/654bd15e-b121-49ba-a588-960956b15175/"
private const val PRODUCT_API = "https://run.mocky.io/v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5"

interface StoreApi {

    @GET(".")
    suspend fun getHotSales(): HotSaleStorage

    @GET(".")
    suspend fun getBestDeals(): BestDealsStorage

    @GET(".")
    suspend fun getProductDetails(): ProductStorage

    @GET(".")
    suspend fun getCart(): CartStorage

    object RetrofitBuilder {
        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(STORE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val apiService: StoreApi = getRetrofit().create(StoreApi::class.java)
    }
}