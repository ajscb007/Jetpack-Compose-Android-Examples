package com.mme.androidarchitecture.presentation.di

import com.mme.androidarchitecture.domain.repository.Repository
import com.mme.androidarchitecture.domain.usecase.GetNewsHeadlinesUseCase
import com.mme.androidarchitecture.domain.usecase.GetSavedNewsUseCase
import com.mme.androidarchitecture.domain.usecase.SaveNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetNewsheadLinesUseCase(
        newsRepository: Repository
    ): GetNewsHeadlinesUseCase {
        return GetNewsHeadlinesUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideSaveNewsUseCase(
        newsRepository: Repository
    ): SaveNewsUseCase {
        return SaveNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSavedNewsUseCase(
        repository: Repository
    ): GetSavedNewsUseCase {
        return GetSavedNewsUseCase(repository)
    }
}


















