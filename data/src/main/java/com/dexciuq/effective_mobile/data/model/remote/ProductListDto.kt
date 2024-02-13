package com.dexciuq.effective_mobile.data.model.remote

import com.google.gson.annotations.SerializedName

data class ProductListDto(
    @SerializedName("items")
    val items: List<ProductDto>
)