package com.example.jetpack.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack.domain.entities.Article
import com.example.jetpack.presentation.views.ArticleList
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun HomeScreen(viewModel: HomeViewModel = HomeViewModel()) {
    val topHeadlines: List<Article> by viewModel.topHeadlines.observeAsState(emptyList())

    Scaffold(
        content = {
            Column(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Header()
                Column(
                    Modifier.fillMaxHeight()
                        .background(Color.Cyan)
                ){
                    ArticleList(articles = topHeadlines)
                }
            }
        }
    )
}

@Composable
fun Header() {
    Column(
        Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(54.dp)
    ){}
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

