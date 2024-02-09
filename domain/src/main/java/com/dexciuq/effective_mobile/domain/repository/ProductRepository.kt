package com.dexciuq.effective_mobile.domain.repository

import com.dexciuq.effective_mobile.common.Resource
import com.dexciuq.effective_mobile.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProductList(): Flow<Resource<List<Product>>>
    suspend fun getProduct(id: String): Flow<Resource<Product>>
    suspend fun addToFavorites(product: Product)
    suspend fun removeFromFavorites(product: Product)
}