package com.mme.androidarchitecture.data.api

import com.mme.androidarchitecture.BuildConfig
import com.mme.androidarchitecture.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
  @GET("v2/top-headlines")
  suspend fun getTopHeadlines(
      @Query("country")
      country:String,
      @Query("page")
      page:Int,
      @Query("apiKey")
      apiKey:String = BuildConfig.API_KEY
  ): Response<APIResponse>

    @GET("v2/top-headlines")
    suspend fun getSearchedTopHeadlines(
        @Query("country")
        country:String,
        @Query("q")
        searchQuery:String,
        @Query("page")
        page:Int,
        @Query("apiKey")
        apiKey:String = BuildConfig.API_KEY
    ): Response<APIResponse>

}