package com.example.jetpack.presentation.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.jetpack.domain.entities.Article

@Composable
fun ArticleList(articles: List<Article>) {
    LazyColumn {
        items(articles) { item -> ArticleItem(article = item) }
    }
}