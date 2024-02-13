package com.dexciuq.effective_mobile.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductPrice(
    val price: String,
    val discount: Int,
    val priceWithDiscount: String,
    val unit: String
) : Parcelable
