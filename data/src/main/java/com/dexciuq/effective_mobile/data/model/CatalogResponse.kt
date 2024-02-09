package com.dexciuq.effective_mobile.data.model

import com.google.gson.annotations.SerializedName

data class CatalogResponse(
    @SerializedName("items")
    val items: List<Item>
)