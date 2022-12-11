package com.sarbaevartur.data.data.storage.models

import com.google.gson.annotations.SerializedName

data class ProductStorage(

    @SerializedName("CPU")
    val cpu: String,

    @SerializedName("camera")
    val camera: String,

    @SerializedName("capacity")
    val capacity: List<String>,

    @SerializedName("color")
    val color: List<String>,

    @SerializedName("images")
    val images: List<String>,

    @SerializedName("isFavorites")
    val is_favourites: Boolean,

    @SerializedName("price")
    val price: Int,

    @SerializedName("rating")
    val rating: Double,

    @SerializedName("sd")
    val sd: String,

    @SerializedName("ssd")
    val ssd: String,

    @SerializedName("title")
    val title: String,
)