package com.example.inshortsclone

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class InshortsApplication: Application() {

    override fun onCreate(){
        super.onCreate()
        Log.d(TAG, "Entering Inshorts Application")
    }

    companion object{
        const val TAG = "InshortsApplication"
    }
}