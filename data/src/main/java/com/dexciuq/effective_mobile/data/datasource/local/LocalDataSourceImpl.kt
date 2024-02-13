package com.dexciuq.effective_mobile.data.datasource.local

import com.dexciuq.effective_mobile.data.datasource.DataSource
import com.dexciuq.effective_mobile.domain.model.Product
import com.dexciuq.effective_mobile.domain.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(

) : DataSource.LocalDataSource {
    override suspend fun getProductList(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun getProduct(id: String): Flow<Product> {
        TODO("Not yet implemented")
    }

    override suspend fun addToFavorites(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromFavorites(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun register(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(): User {
        TODO("Not yet implemented")
    }
}