package com.mme.androidarchitecture.domain.repository

import com.mme.androidarchitecture.data.model.APIResponse
import com.mme.androidarchitecture.data.model.Article
import com.mme.androidarchitecture.data.util.Resource
import kotlinx.coroutines.flow.Flow


interface Repository {
    suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse>
    suspend fun saveNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}