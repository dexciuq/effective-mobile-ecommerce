package com.dexciuq.effective_mobile.data.di

import android.content.Context
import androidx.room.Room
import com.dexciuq.effective_mobile.data.datasource.local.db.AppDatabase
import com.dexciuq.effective_mobile.data.datasource.local.db.dao.ProductDao
import com.dexciuq.effective_mobile.data.datasource.local.db.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "effective_mobile.db"

@Module
@InstallIn(SingletonComponent::class)
class AppDatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context = context.applicationContext,
            klass = AppDatabase::class.java,
            name = DATABASE_NAME,
        ).build()
    }

    @Provides
    @Singleton
    fun provideProductDao(database: AppDatabase): ProductDao {
        return database.productDao()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }
}