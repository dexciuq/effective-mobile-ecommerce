package com.dexciuq.effective_mobile.data.datasource.local

import com.dexciuq.effective_mobile.data.datasource.DataSource
import com.dexciuq.effective_mobile.data.datasource.local.db.dao.ProductDao
import com.dexciuq.effective_mobile.data.datasource.local.db.dao.UserDao
import com.dexciuq.effective_mobile.data.mapper.toDomain
import com.dexciuq.effective_mobile.data.mapper.toEntity
import com.dexciuq.effective_mobile.data.model.local.ProductEntity
import com.dexciuq.effective_mobile.domain.model.Product
import com.dexciuq.effective_mobile.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val userDao: UserDao,
    private val productDao: ProductDao,
) : DataSource.LocalDataSource {
    override suspend fun getProductList(): Flow<List<Product>> =
        productDao.getAll().map(List<ProductEntity>::toDomain)

    override suspend fun getProduct(id: String): Product =
        productDao.getProduct(id).run(ProductEntity::toDomain)

    override suspend fun addToFavorites(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromFavorites(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun register(user: User) =
        userDao.insert(user.toEntity())

    override suspend fun getUser(): User =
        userDao.selectUser(User.USER_ID).toDomain()

    override suspend fun logout() =
        userDao.delete()
}