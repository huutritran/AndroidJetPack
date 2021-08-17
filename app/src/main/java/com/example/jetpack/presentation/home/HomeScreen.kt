package com.example.jetpack.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpack.domain.entities.Article
import com.example.jetpack.presentation.views.ArticleList

@Composable
fun HomeScreen(viewModel: HomeViewModel = HomeViewModel()) {
    val topHeadlines: List<Article> by viewModel.topHeadlines.observeAsState(emptyList())

    Scaffold(
        content = { TopHeadlines(articles = topHeadlines) },
        topBar = { Header() }
    )
}

@Composable
fun Header() {
    TopAppBar(
        title = {
            Text(text = "Top Headlines", color = Color.White)
        },
        backgroundColor = Color(0xFF1976D2)
    )
}

@Composable
fun TopHeadlines(articles: List<Article>) {
    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Column(modifier = Modifier.fillMaxHeight()) {
            ArticleList(articles = articles)
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

