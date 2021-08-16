package com.example.jetpack.data

import com.example.jetpack.domain.entities.Article
import com.example.jetpack.domain.entities.Category
import com.example.jetpack.domain.entities.Source
import com.example.jetpack.domain.repositories.NewsRepository
import kotlinx.coroutines.delay

class MockNewsRepositoryImpl : NewsRepository {
    override suspend fun getTopHeadlines(
        category: Category?,
        source: Source?
    ): Result<List<Article>> {
        delay(3000)
        val articleList = (0..20).map {
            Article(
                id = it.toString(),
                title = "Tropical depression threatens further devastation in earthquake-hit Haiti - CNN",
                description = "A tropical storm system is threatening to unleash flash flooding and mudslides on the area of Haiti where a 7.2-magnitude earthquake killed almost 1,300 people on Saturday.",
                urlToImage = "https://cdn.cnn.com/cnnnext/dam/assets/210816053221-02-haiti-earthquake-0815-file-super-169.jpg",
                publishedAt = "2021-08-16T12:08:00Z",
                source = Source("id", "name", "description", "url", "category"),
                content = "content",
                author = "Matt Rivers and Jack Guy",
                url = "https://www.cnn.com/2021/08/16/americas/haiti-earthquake-news-monday-intl/index.html"
            )
        }

        return  Result.success(articleList)
    }

    override suspend fun getSources(): Result<List<Source>> {
        TODO("Not yet implemented")
    }
}