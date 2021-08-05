package com.example.jetpack.domain.usecases

import com.example.jetpack.domain.entities.Source
import com.example.jetpack.domain.repositories.NewsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

class GetSources(
    mainDispatcher: CoroutineDispatcher,
    ioDispatcher: CoroutineDispatcher,
    private val newsRepository: NewsRepository, coroutineScope: CoroutineScope
):  UseCase<List<Source>, UseCase.None>(
    mainDispatcher, ioDispatcher, coroutineScope
) {
    override suspend fun run(params: None): Result<List<Source>> {
        return newsRepository.getSources()
    }
}