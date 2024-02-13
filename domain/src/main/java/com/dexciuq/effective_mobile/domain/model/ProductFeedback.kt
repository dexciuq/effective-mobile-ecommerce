package com.dexciuq.effective_mobile.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductFeedback(
    val count: Int,
    val rating: Double
) : Parcelable