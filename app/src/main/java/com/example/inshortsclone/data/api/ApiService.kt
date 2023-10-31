package com.example.inshortsclone.data.api

import com.example.inshortsclone.data.entity.InshortsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "17fbba1517ed468ba8f378f3d510463a"
    ) : Response<InshortsResponse>
}

// https://newsapi.org/v2/top-headlines?country=in&apiKey=17fbba1517ed468ba8f378f3d510463a