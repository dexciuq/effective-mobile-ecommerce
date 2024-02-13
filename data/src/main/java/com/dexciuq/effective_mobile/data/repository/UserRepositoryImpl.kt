package com.dexciuq.effective_mobile.data.repository

import com.dexciuq.effective_mobile.data.datasource.DataSource
import com.dexciuq.effective_mobile.domain.model.User
import com.dexciuq.effective_mobile.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val localDataSource: DataSource.LocalDataSource,
    private val preferenceDataSource: DataSource.PreferenceDataSource,
) : UserRepository {
    override suspend fun getAuthSkip(): Boolean =
        preferenceDataSource.getAuthSkip()

    override suspend fun setAuthSkip(skip: Boolean) =
        preferenceDataSource.setAuthSkip(skip)

    override suspend fun register(user: User) =
        localDataSource.register(user)

    override suspend fun getUser(): User =
        localDataSource.getUser()

    override suspend fun logout() =
        localDataSource.logout()
}