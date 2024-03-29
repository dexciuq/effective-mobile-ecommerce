package com.dexciuq.effective_mobile.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: String,
    val title: String,
    val subtitle: String,
    var liked: Boolean,
    val price: ProductPrice,
    val feedback: ProductFeedback,
    val tags: List<String>,
    val available: Int,
    val description: String,
    val info: List<ProductInfo>,
    val ingredients: String,
): Parcelable
