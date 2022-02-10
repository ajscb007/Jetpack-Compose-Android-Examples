package com.mme.androidarchitecture.presentation.di

import android.app.Application
import com.mme.androidarchitecture.domain.usecase.GetNewsHeadlinesUseCase
import com.mme.androidarchitecture.domain.usecase.GetSavedNewsUseCase
import com.mme.androidarchitecture.domain.usecase.SaveNewsUseCase
import com.mme.androidarchitecture.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
    fun provideViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        saveNewsUseCase: SaveNewsUseCase,
        getSavedNewsUseCase: GetSavedNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            application,
            getNewsHeadlinesUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase
        )
    }
}








