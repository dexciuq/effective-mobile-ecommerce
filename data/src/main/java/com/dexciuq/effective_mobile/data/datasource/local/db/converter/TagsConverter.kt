package com.dexciuq.effective_mobile.data.datasource.local.db.converter

import androidx.room.TypeConverter

class TagsConverter {
    @TypeConverter
    fun toString(tags: List<String>): String {
        return tags.joinToString(SEPARATOR)
    }

    @TypeConverter
    fun fromString(plaintext: String): List<String> {
        return plaintext.split(SEPARATOR)
    }

    companion object {
        private const val SEPARATOR = ","
    }
}