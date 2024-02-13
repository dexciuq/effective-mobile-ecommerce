package com.dexciuq.effective_mobile.data.datasource

import com.dexciuq.effective_mobile.domain.model.Product
import com.dexciuq.effective_mobile.domain.model.User
import kotlinx.coroutines.flow.Flow

interface DataSource {
    interface RemoteDataSource {
        suspend fun getProductList(): List<Product>
    }

    interface LocalDataSource {
        suspend fun getProductList(): Flow<List<Product>>
        suspend fun getProduct(id: String): Flow<Product>
        suspend fun addToFavorites(product: Product)
        suspend fun removeFromFavorites(product: Product)
        suspend fun register(user: User)
        suspend fun getUser(): User
    }

    interface PreferenceDataSource {

    }
}