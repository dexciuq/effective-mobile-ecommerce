package com.dexciuq.effective_mobile.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dexciuq.effective_mobile.domain.model.ProductFeedback
import com.dexciuq.effective_mobile.domain.model.ProductInfo
import com.dexciuq.effective_mobile.domain.model.ProductPrice

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "subtitle")
    val subtitle: String,
    @Embedded(prefix = "product_")
    val price: ProductPrice,
    @ColumnInfo(name = "liked")
    val liked: Boolean,
    @Embedded(prefix = "feedback_")
    val feedback: ProductFeedback,
    @ColumnInfo(name = "tags")
    val tags: List<String>,
    @ColumnInfo(name = "available")
    val available: Int,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "info")
    val info: List<ProductInfo>,
    @ColumnInfo(name = "ingredients")
    val ingredients: String
)