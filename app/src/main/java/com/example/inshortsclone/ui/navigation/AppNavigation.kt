package com.example.inshortsclone.ui.navigation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.inshortsclone.ui.screens.HomeScreen
import com.example.inshortsclone.ui.viewmodel.InshortsViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigationGraph(){
    val viewModel: InshortsViewModel = hiltViewModel()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN){
        composable(Routes.HOME_SCREEN){
            HomeScreen(viewModel)
        }
    }
}