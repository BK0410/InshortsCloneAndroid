package com.example.inshortsclone.data.datasource

import com.example.inshortsclone.data.entity.InshortsResponse
import retrofit2.Response
import retrofit2.http.GET

interface InshortsDataSource {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(country: String) : Response<InshortsResponse>

}