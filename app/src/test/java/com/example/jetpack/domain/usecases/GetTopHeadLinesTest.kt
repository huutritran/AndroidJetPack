package com.example.jetpack.domain.usecases

import com.example.jetpack.domain.entities.Article
import com.example.jetpack.domain.repositories.NewsRepository
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetTopHeadLinesTest {
    lateinit var newsRepository:NewsRepository
    lateinit var ioDispatcher: CoroutineDispatcher
    lateinit var mainDispatcher: CoroutineDispatcher
    lateinit var scope: CoroutineScope

    @Before
    fun setup(){
        newsRepository = mockk<NewsRepository>(relaxed = true)
        ioDispatcher = Dispatchers.Unconfined
        mainDispatcher = Dispatchers.Unconfined
        scope = CoroutineScope(Dispatchers.Unconfined)
    }

    @Test
    fun `getTopHeadlines should return result success` () {
        //given
        val getTopHeadlines = GetTopHeadlines(
            ioDispatcher = ioDispatcher,
            mainDispatcher = mainDispatcher,
            newsRepository = newsRepository
        )

        coEvery { newsRepository.getTopHeadlines() } returns Result.success(
            listOf(
                Article(
                    id = "1",
                    title = "title",
                    description = "description",
                    urlToImage = "urlToImage",
                    publishedAt = "publishedAt"
                )
            )
        )
        var result:Result<List<Article>> = Result.failure(Error("Unknown error"))
        val onResult: (Result<List<Article>>) -> Unit = { it -> result = it}

        //when
        runBlocking {
            getTopHeadlines(UseCase.None(), scope = scope, onResult = onResult)
        }

        //then
        coVerify { newsRepository.getTopHeadlines() }
        result.isSuccess shouldBe true
        result.getOrNull() shouldBe listOf(Article(
            id = "1",
            title = "title",
            description = "description",
            urlToImage = "urlToImage",
            publishedAt = "publishedAt"
        ))
    }

}