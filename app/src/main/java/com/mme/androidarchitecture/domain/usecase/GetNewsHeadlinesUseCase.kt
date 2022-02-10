package com.mme.androidarchitecture.domain.usecase

import com.mme.androidarchitecture.data.model.APIResponse
import com.mme.androidarchitecture.data.util.Resource
import com.mme.androidarchitecture.domain.repository.Repository


class GetNewsHeadlinesUseCase(private val newsRepository: Repository) {

    suspend fun execute(country : String, page : Int): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(country, page)
    }

}