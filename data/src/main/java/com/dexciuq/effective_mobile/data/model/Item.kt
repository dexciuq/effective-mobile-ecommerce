package com.dexciuq.effective_mobile.data.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("price")
    val price: Price,
    @SerializedName("feedback")
    val feedback: Feedback,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("available")
    val available: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("info")
    val info: List<Info>,
    @SerializedName("ingredients")
    val ingredients: String
)