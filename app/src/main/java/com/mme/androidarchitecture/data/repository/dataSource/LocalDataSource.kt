package com.mme.androidarchitecture.data.repository.dataSource

import com.mme.androidarchitecture.data.model.Article
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun saveArticleToDB(article: Article)
    fun getSavedArticles(): Flow<List<Article>>
}