package com.sarbaevartur.data.data.storage.models

import com.google.gson.annotations.SerializedName

data class BestDealsStorage(
    @SerializedName("best_seller")
    var dealsList: List<BestDealPost>? = null
)

data class BestDealPost(

    @SerializedName("is_favorites")
    val is_favourites: Boolean,

    @SerializedName("title")
    val title: String,

    @SerializedName("price_without_discount")
    val price_without_discount: Int,

    @SerializedName("discount_price")
    val discount_price: Int,

    @SerializedName("picture")
    val picture: String,
)