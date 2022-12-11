package com.sarbaevartur.data.data.storage.models

import com.google.gson.annotations.SerializedName
import com.sarbaevartur.domain.models.CartItem

data class CartStorage(
    @SerializedName("basket")
    val basket: List<CartItem>,

    @SerializedName("delivery")
    val delivery: String,

    @SerializedName("total")
    val total: Int
)

data class CartItemStorage(

    @SerializedName("image")
    val image: String,

    @SerializedName("price")
    val price: Int,

    @SerializedName("title")
    val title: String,
)