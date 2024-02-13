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
            val remoteProductList = remoteDataSource.getProductList()
            localDataSource.getProductList().collect {
                val merged = remoteProductList.map { remoteProduct ->
                    remoteProduct.liked = it.find { it.id == remoteProduct.id }?.liked ?: false
                    remoteProduct
                }
                emit(Resource.Success(merged))
            }
        } catch (t: Throwable) {
            emit(Resource.Error(t))
        }
    }

    override suspend fun getFavoriteList(): Flow<Resource<List<Product>>> = flow {
        emit(Resource.Loading)
        try {
            localDataSource.getProductList().collect {
                emit(Resource.Success(it))
            }
        } catch (t: Throwable) {
            emit(Resource.Error(t))
        }
    }

    override suspend fun getProduct(id: String): Flow<Resource<Product>> = flow {
        emit(Resource.Loading)
        try {
            val product = remoteDataSource.getProduct(id)
            localDataSource.getProduct(id).collect {
                product.liked = it.liked
                emit(Resource.Success(product))
            }
        } catch (t: Throwable) {
            emit(Resource.Error(t))
        }
    }

    override suspend fun addToFavorites(product: Product) =
        localDataSource.addToFavorites(product)

    override suspend fun removeFromFavorites(product: Product) =
        localDataSource.removeFromFavorites(product)
}