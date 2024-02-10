package com.dexciuq.effective_mobile.data.repository

import com.dexciuq.effective_mobile.common.Resource
import com.dexciuq.effective_mobile.domain.model.Product
import com.dexciuq.effective_mobile.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(

) : ProductRepository {
    override suspend fun getProductList(): Flow<Resource<List<Product>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getProduct(id: String): Flow<Resource<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun addToFavorites(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromFavorites(product: Product) {
        TODO("Not yet implemented")
    }
}