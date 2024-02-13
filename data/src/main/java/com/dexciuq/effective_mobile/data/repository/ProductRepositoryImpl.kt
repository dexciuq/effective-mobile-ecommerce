package com.dexciuq.effective_mobile.data.repository

import com.dexciuq.effective_mobile.common.Resource
import com.dexciuq.effective_mobile.data.datasource.DataSource
import com.dexciuq.effective_mobile.domain.model.Product
import com.dexciuq.effective_mobile.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val remoteDataSource: DataSource.RemoteDataSource,
    private val localDataSource: DataSource.LocalDataSource,
) : ProductRepository {
    override suspend fun getProductList(): Flow<Resource<List<Product>>> = flow {
        emit(Resource.Loading)
        try {
            val productList = remoteDataSource.getProductList()
            emit(Resource.Success(productList))
        } catch (t: Throwable) {
            emit(Resource.Error(t))
        }
    }

    override suspend fun getProduct(id: String): Flow<Resource<Product>> = flow {
        emit(Resource.Loading)
        try {
            val product = remoteDataSource.getProductList().find { it.id == id }
                ?: error("unknown id")

            emit(Resource.Success(product))
        } catch (t: Throwable) {
            emit(Resource.Error(t))
        }
    }

    override suspend fun addToFavorites(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromFavorites(product: Product) {
        TODO("Not yet implemented")
    }
}