package com.dexciuq.effective_mobile.data.model.remote

import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("price")
    val price: ProductPriceDto,
    @SerializedName("feedback")
    val feedback: ProductFeedbackDto,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("available")
    val available: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("info")
    val info: List<ProductInfoDto>,
    @SerializedName("ingredients")
    val ingredients: String
)