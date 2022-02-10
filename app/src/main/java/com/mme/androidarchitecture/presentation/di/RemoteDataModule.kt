package com.mme.androidarchitecture.presentation.di

import com.mme.androidarchitecture.data.api.APIService
import com.mme.androidarchitecture.data.repository.dataSource.RemoteDataSource
import com.mme.androidarchitecture.data.repository.dataSourceImpl.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        newsAPIService: APIService
    ):RemoteDataSource{
        return RemoteDataSourceImpl(newsAPIService)
    }

}












