package com.example.inshortsclone.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inshortsclone.data.AppConstants
import com.example.inshortsclone.data.entity.InshortsResponse
import com.example.inshortsclone.ui.repository.InshortsRepository
import com.example.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class InshortsViewModel @Inject constructor(private val inshortsRepository: InshortsRepository) : ViewModel() {

    init{
        getNews(AppConstants.COUNTRY)
    }

    val _news: MutableStateFlow<ResourceState<InshortsResponse>> = MutableStateFlow(ResourceState.Loading())
    val news:StateFlow<ResourceState<InshortsResponse>> = _news

    private fun getNews(country: String){
        viewModelScope.launch(Dispatchers.IO) {
            inshortsRepository.getNewsHeadline(country)
                .collectLatest { inshortsResponse ->
                    _news.value = inshortsResponse
                }
        }
    }

    companion object{
        const val TAG = "InshortsViewModel"
    }
}