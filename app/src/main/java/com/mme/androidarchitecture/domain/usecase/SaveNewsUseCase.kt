package com.mme.androidarchitecture.domain.usecase

import com.mme.androidarchitecture.data.model.APIResponse
import com.mme.androidarchitecture.data.model.Article
import com.mme.androidarchitecture.data.util.Resource
import com.mme.androidarchitecture.domain.repository.Repository

class SaveNewsUseCase(private val newsRepository: Repository) {

    suspend fun execute(article: Article) = newsRepository.saveNews(article)

}