package com.mme.androidarchitecture.domain.usecase

import com.mme.androidarchitecture.data.model.Article
import com.mme.androidarchitecture.domain.repository.Repository
import kotlinx.coroutines.flow.Flow


class GetSavedNewsUseCase(private val repository: Repository) {
    fun execute(): Flow<List<Article>> {
        return  repository.getSavedNews()
    }
}