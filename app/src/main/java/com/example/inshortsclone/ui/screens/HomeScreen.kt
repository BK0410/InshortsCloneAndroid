package com.example.inshortsclone.ui.screens

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.FileProvider
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inshortsclone.ui.components.Loader
import com.example.inshortsclone.ui.components.NewsRowComponent
import com.example.inshortsclone.ui.viewmodel.InshortsViewModel
import com.example.utilities.ResourceState
import dev.shreyaspatil.capturable.Capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(viewModel: InshortsViewModel = hiltViewModel()){

    val TAG = "HomeScreen"
    val inshortsResponse by viewModel.news.collectAsState()

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    )
    val captureController = rememberCaptureController()
    val context: Context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Capturable(
        controller = captureController,
        onCaptured = { bitmap, error ->
            if (bitmap != null) {
                coroutineScope.launch {
                    try {
                        val file = File(context.cacheDir, "sharedImage.jpg")
                        val fileOutputStream = FileOutputStream(file)
                        bitmap.asAndroidBitmap().compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
                        fileOutputStream.close()

                        val uri = FileProvider.getUriForFile(context, "com.example.inshortsclone.fileprovider", file)

                        val shareIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "image/*"
                            putExtra(Intent.EXTRA_STREAM, uri)
                        }

                        startActivity(context, Intent.createChooser(shareIntent, "Share Image"), null)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }


            }

        }
    ) {
            VerticalPager(
                state = pagerState,
                pageSize = PageSize.Fill,
                pageSpacing = 8.dp,
                pageCount = 100,
                modifier = Modifier.fillMaxSize()) { page: Int ->
                when (inshortsResponse) {
                    is ResourceState.Loading -> {
                        Log.d(TAG, "Inside Homescreen")
                        Loader()
                    }

                    is ResourceState.Success -> {
                        val response = (inshortsResponse as ResourceState.Success).data
                        Log.d(TAG, "Inside Success - ${response.status} = ${response.totalResults}")
                        if (response.articles.isNotEmpty()) {
//                            HorizontalPager(pageCount = 2,pageSize = PageSize.Fill,modifier = Modifier.fillMaxSize()) {
                                NewsRowComponent(page, response.articles.get(page))
//                            }



                            Box(contentAlignment = Alignment.TopEnd, modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp)){
                                Button(onClick = { captureController.capture(Bitmap.Config.ARGB_8888) }, shape = CircleShape) {
                                    Icon(imageVector = Icons.Default.Share, contentDescription = "Share News", modifier = Modifier.size(32.dp))
                                }
                            }
                        }
                    }

                    is ResourceState.Error -> {
                        val response = inshortsResponse as ResourceState.Error
                        Log.d(TAG, "Inside Error - ${response.error}")
                    }

                }


        }


    }






}