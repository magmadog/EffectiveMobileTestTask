package com.sarbaevartur.domain.models

data class Cart (
    val basket: List<CartItem>,
    val delivery: String,
    val total: Int
    )