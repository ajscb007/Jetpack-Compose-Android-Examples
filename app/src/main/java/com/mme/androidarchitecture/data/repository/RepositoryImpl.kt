package com.mme.androidarchitecture.data.repository

import com.mme.androidarchitecture.data.model.APIResponse
import com.mme.androidarchitecture.data.model.Article
import com.mme.androidarchitecture.data.repository.dataSource.LocalDataSource
import com.mme.androidarchitecture.data.repository.dataSource.RemoteDataSource
import com.mme.androidarchitecture.data.util.Resource
import com.mme.androidarchitecture.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): Repository {
    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(remoteDataSource.getTopHeadlines(country, page))
    }

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun saveNews(article: Article) {
        localDataSource.saveArticleToDB(article)
    }

    override fun getSavedNews(): Flow<List<Article>> {
        return localDataSource.getSavedArticles()
    }
}