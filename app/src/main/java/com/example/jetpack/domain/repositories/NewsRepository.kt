package com.example.jetpack.domain.repositories

import com.example.jetpack.domain.entities.Article
import com.example.jetpack.domain.entities.ArticleFullInfo

interface NewsRepository {
    suspend fun getTopHeadlines(): Result<List<Article>>

    suspend fun getArticleDetail(id: String): Result<ArticleFullInfo>
}