package com.mme.androidarchitecture.presentation.di

import com.mme.androidarchitecture.data.repository.RepositoryImpl
import com.mme.androidarchitecture.data.repository.dataSource.LocalDataSource
import com.mme.androidarchitecture.data.repository.dataSource.RemoteDataSource
import com.mme.androidarchitecture.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): Repository {
        return RepositoryImpl(
            remoteDataSource,
            localDataSource
        )
    }

}














