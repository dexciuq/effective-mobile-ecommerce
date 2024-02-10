package com.dexciuq.effective_mobile.data.model.remote

import com.google.gson.annotations.SerializedName

data class ProductFeedbackDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("rating")
    val rating: Double
)