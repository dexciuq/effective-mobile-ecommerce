package com.dexciuq.effective_mobile.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dexciuq.effective_mobile.data.datasource.local.db.converter.InfoConverter
import com.dexciuq.effective_mobile.data.datasource.local.db.converter.TagsConverter
import com.dexciuq.effective_mobile.data.datasource.local.db.dao.ProductDao
import com.dexciuq.effective_mobile.data.datasource.local.db.dao.UserDao
import com.dexciuq.effective_mobile.data.model.local.ProductEntity
import com.dexciuq.effective_mobile.data.model.local.UserEntity

@Database(entities = [ProductEntity::class, UserEntity::class], version = 1, exportSchema = false)
@TypeConverters(TagsConverter::class, InfoConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun userDao(): UserDao
}