package com.example.inshortsclone.ui.repository

import com.example.inshortsclone.data.datasource.InshortsDataSource
import com.example.inshortsclone.data.entity.InshortsResponse
import com.example.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class InshortsRepository @Inject constructor(private val inshortsDataSource: InshortsDataSource) {

//    suspend fun getNewsHeadline(country:String): Response<InshortsResponse>{
//        return inshortsDataSource.getNewsHeadline(country)
//    }

    suspend fun getNewsHeadline(country:String): Flow<ResourceState<InshortsResponse>> {
        return flow{
            emit(ResourceState.Loading())

            val response = inshortsDataSource.getNewsHeadline(country)

            if(response.isSuccessful && response != null){
                emit(ResourceState.Success(response.body()!!))
            }else{
                emit(ResourceState.Error("SOMETHING WENT WRONG"))
            }
        }.catch { e ->
                emit(ResourceState.Error(e?.localizedMessage ?: "SOMETHING WENT WRONG IN FLOW"))
        }
    }
}