package com.dexciuq.effective_mobile.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dexciuq.effective_mobile.domain.model.ProductFeedback
import com.dexciuq.effective_mobile.domain.model.ProductInfo
import com.dexciuq.effective_mobile.domain.model.ProductPrice

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val surname: String,
    val phoneNumber: String,
)