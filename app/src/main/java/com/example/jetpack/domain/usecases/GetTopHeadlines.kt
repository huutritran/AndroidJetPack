package com.example.jetpack.domain.usecases

import com.example.jetpack.domain.entities.Article
import com.example.jetpack.domain.repositories.NewsRepository
import kotlinx.coroutines.CoroutineDispatcher


class GetTopHeadlines(
    mainDispatcher: CoroutineDispatcher,
    ioDispatcher: CoroutineDispatcher,
    private val newsRepository: NewsRepository
) :
    UseCase<List<Article>, UseCase.None>(
        mainDispatcher, ioDispatcher
    ) {
    override suspend fun run(params: None): Result<List<Article>> {
        return newsRepository.getTopHeadlines()
    }
}