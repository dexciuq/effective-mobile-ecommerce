package com.dexciuq.effective_mobile.data.model.remote

import com.google.gson.annotations.SerializedName

data class ProductInfoDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("value")
    val value: String
)