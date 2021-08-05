package com.example.jetpack.domain.usecases

import com.example.jetpack.domain.entities.Article
import com.example.jetpack.domain.entities.Category
import com.example.jetpack.domain.repositories.NewsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope


class GetTopHeadlines(
    mainDispatcher: CoroutineDispatcher,
    ioDispatcher: CoroutineDispatcher,
    coroutineScope: CoroutineScope,
    private val newsRepository: NewsRepository,
) :
    UseCase<List<Article>, GetTopHeadlines.Params>(
        mainDispatcher, ioDispatcher, coroutineScope
    ) {

    override suspend fun run(params: Params): Result<List<Article>> {
        return newsRepository.getTopHeadlines(params.category, null)
    }

    data class Params(
        val category: Category
    )
}