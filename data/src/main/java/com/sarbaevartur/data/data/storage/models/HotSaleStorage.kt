package com.sarbaevartur.data.data.storage.models

import com.google.gson.annotations.SerializedName

data class HotSaleStorage(
    @SerializedName("home_store")
    var lst: List<HotSalePost>? = null
)

data class HotSalePost(

    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("subtitle")
    var subtitle: String? = null,

    @SerializedName("is_new")
    var isnew: Boolean? = null,

    @SerializedName("picture")
    var picture: String? = null,

    @SerializedName("is_buy")
    var isbuy: Boolean? = null
)