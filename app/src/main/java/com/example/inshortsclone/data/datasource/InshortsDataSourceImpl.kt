package com.example.inshortsclone.data.datasource

import com.example.inshortsclone.data.api.ApiService
import com.example.inshortsclone.data.entity.InshortsResponse
import retrofit2.Response
import javax.inject.Inject

class InshortsDataSourceImpl @Inject constructor( private val apiService: ApiService): InshortsDataSource {

    override suspend fun getNewsHeadline(country: String): Response<InshortsResponse> {
        return apiService.getNewsHeadline(country)
    }
}