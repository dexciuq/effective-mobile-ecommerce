package com.dexciuq.effective_mobile.domain.model

data class Product(
    val id: String,
    val title: String,
    val subtitle: String,
    val price: ProductPrice,
    val feedback: ProductFeedback,
    val tags: List<String>,
    val available: Int,
    val description: String,
    val info: List<ProductInfo>,
    val ingredients: String,
)
