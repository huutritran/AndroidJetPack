package com.example.jetpack.domain.repositories

import com.example.jetpack.domain.entities.Article
import com.example.jetpack.domain.entities.Category
import com.example.jetpack.domain.entities.Source

interface NewsRepository {
    suspend fun getTopHeadlines(
        category: Category? = null,
        source: Source? = null
    ): Result<List<Article>>

    suspend fun getSources(): Result<List<Source>>
}