package com.dexciuq.effective_mobile.data.datasource.remote

import com.dexciuq.effective_mobile.data.datasource.DataSource
import com.dexciuq.effective_mobile.data.mapper.toDomain
import com.dexciuq.effective_mobile.data.model.remote.ProductDto
import com.dexciuq.effective_mobile.domain.model.Product
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : DataSource.RemoteDataSource {
    override suspend fun getProductList(): List<Product> =
        apiService.getProductList().items.map(ProductDto::toDomain)

    override suspend fun getProduct(id: String): Product =
        apiService.getProductList().items.find { it.id == id }?.toDomain()
            ?: error("unknown id")
}