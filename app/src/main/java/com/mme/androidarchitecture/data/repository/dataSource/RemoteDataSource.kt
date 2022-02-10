package com.mme.androidarchitecture.data.repository.dataSource

import com.mme.androidarchitecture.data.model.APIResponse
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getTopHeadlines(country : String, page : Int):Response<APIResponse>

}