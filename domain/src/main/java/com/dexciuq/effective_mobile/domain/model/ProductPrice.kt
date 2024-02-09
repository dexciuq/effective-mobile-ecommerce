package com.dexciuq.effective_mobile.domain.model

data class ProductPrice(
    val price: String,
    val discount: Int,
    val priceWithDiscount: String,
    val unit: String
)
