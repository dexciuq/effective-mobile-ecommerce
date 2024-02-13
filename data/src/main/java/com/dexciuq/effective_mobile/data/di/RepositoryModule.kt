package com.dexciuq.effective_mobile.data.di

import com.dexciuq.effective_mobile.data.repository.ProductRepositoryImpl
import com.dexciuq.effective_mobile.data.repository.UserRepositoryImpl
import com.dexciuq.effective_mobile.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepositoryImpl

    @Binds
    fun provideProductRepository(productRepositoryImpl: ProductRepositoryImpl): ProductRepository
}