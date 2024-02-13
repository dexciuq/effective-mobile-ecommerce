package com.dexciuq.effective_mobile.data.datasource.local.db.converter

import androidx.room.TypeConverter
import com.dexciuq.effective_mobile.domain.model.ProductInfo
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class InfoConverter {
    @TypeConverter
    fun toString(tags: List<ProductInfo>): String {
        return Gson().toJson(tags)
    }

    @TypeConverter
    fun fromString(plaintext: String): List<ProductInfo> {
        return Gson().fromJson(plaintext, object : TypeToken<List<ProductInfo>>() {}.type)
    }
}