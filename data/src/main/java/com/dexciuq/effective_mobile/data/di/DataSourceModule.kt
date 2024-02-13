package com.dexciuq.effective_mobile.data.di

import com.dexciuq.effective_mobile.data.datasource.DataSource
import com.dexciuq.effective_mobile.data.datasource.local.LocalDataSourceImpl
import com.dexciuq.effective_mobile.data.datasource.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindPreferenceDataSource(preferenceDataSource: DataSource.PreferenceDataSource): DataSource.PreferenceDataSource

    @Binds
    fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): DataSource.LocalDataSource

    @Binds
    fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): DataSource.RemoteDataSource
}