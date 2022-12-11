package com.sarbaevartur.domain.models

data class BestDeal(
    val is_favourites: Boolean,
    val title: String,
    val price_without_discount: Int,
    val discount_price: Int,
    val picture: String,
)