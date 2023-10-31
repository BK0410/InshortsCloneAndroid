package com.example.inshortsclone.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.inshortsclone.R
import com.example.inshortsclone.data.entity.Article
import com.example.inshortsclone.data.entity.InshortsResponse
import com.example.inshortsclone.ui.theme.Purple40
import java.time.format.TextStyle


@Composable
fun Loader(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        CircularProgressIndicator(
            strokeWidth = 5.dp,
            modifier = Modifier
                .padding(8.dp)
                .size(50.dp),
            color = Purple40
        )
    }

}

@Composable
fun NewsList(response: InshortsResponse){
    LazyColumn{
        items(response.articles){article ->
            NewsTextComponent(newsText = article.title ?: "NA")
        }
    }
}

@Composable
fun NewsTextComponent(newsText:String){
    Text(text = newsText,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal)

}

@Composable
fun NewsRowComponent(page:Int, article: Article){
    Column(Modifier.fillMaxSize()) {
//        NewsTextComponent(newsText = "${page} \n ${article.title}")
        AsyncImage(
            model = article.urlToImage,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            placeholder = painterResource(id = R.drawable.placeholder),
            error = painterResource(id = R.drawable.placeholder)
            )
        Spacer(modifier = Modifier.height(20.dp))
        
        NewsHeadline(article.title ?: "Headline N/A")
        Spacer(modifier = Modifier.height(20.dp))
        NewsContent(article.description ?: "Content N/A")
        Spacer(modifier = Modifier.weight(1f))
        NewsFooter(article.author ?: "Author N/A", article.source.name ?: "Source N/A")
    }

}

@Composable
fun NewsHeadline(title:String?){
    Text(
        text = title ?: "",
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        fontFamily = FontFamily.Serif,
        modifier = Modifier.padding(start=12.dp, end=12.dp),
        lineHeight = 32.sp
        )
}

@Composable
fun NewsContent(content:String?){
    Text(
        text = content ?: "No Content Available",
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        fontFamily = FontFamily.Serif,
        modifier = Modifier.padding(start=12.dp, end=12.dp),
        lineHeight = 26.sp
    )
}

@Composable
fun NewsFooter(author:String, source:String){
    Row(modifier = Modifier.padding(start = 12.dp, end=12.dp, bottom = 24.dp)) {
        Text(text = author, fontFamily = FontFamily.Serif, color = Color.Gray)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = source, fontFamily = FontFamily.Serif, color = Color.Gray)
    }
}