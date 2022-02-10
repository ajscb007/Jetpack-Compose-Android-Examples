package com.mme.androidarchitecture.data.repository.dataSourceImpl

import com.mme.androidarchitecture.data.db.ArticleDAO
import com.mme.androidarchitecture.data.model.Article
import com.mme.androidarchitecture.data.repository.dataSource.LocalDataSource
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(
    private val articleDAO: ArticleDAO
): LocalDataSource {
    override suspend fun saveArticleToDB(article: Article) {
        articleDAO.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDAO.getAllArticles()
    }
}