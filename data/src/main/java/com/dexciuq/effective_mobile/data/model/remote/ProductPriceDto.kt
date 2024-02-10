package com.dexciuq.effective_mobile.data.model.remote

import com.google.gson.annotations.SerializedName

data class ProductPriceDto(
    @SerializedName("price")
    val price: String,
    @SerializedName("discount")
    val discount: Int,
    @SerializedName("priceWithDiscount")
    val priceWithDiscount: String,
    @SerializedName("unit")
    val unit: String
)