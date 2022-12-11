package com.sarbaevartur.domain.models

data class HotSale(
    val is_new: Boolean,
    val title: String,
    val subtitle: String,
    val picture: String,
    val is_buy: Boolean
)