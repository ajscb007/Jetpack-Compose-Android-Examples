package com.mme.androidarchitecture.presentation.di

import com.mme.androidarchitecture.data.db.ArticleDAO
import com.mme.androidarchitecture.data.repository.dataSource.LocalDataSource
import com.mme.androidarchitecture.data.repository.dataSourceImpl.LocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(articleDAO: ArticleDAO):LocalDataSource{
        return LocalDataSourceImpl(articleDAO)
    }

}













