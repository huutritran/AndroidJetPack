package com.example.jetpack.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack.data.MockNewsRepositoryImpl
import com.example.jetpack.domain.entities.Article
import com.example.jetpack.domain.entities.Category
import com.example.jetpack.domain.repositories.NewsRepository
import com.example.jetpack.domain.usecases.GetTopHeadlines
import kotlinx.coroutines.Dispatchers

class HomeViewModel : ViewModel() {
    private var newsRepository: NewsRepository = MockNewsRepositoryImpl()
    private var getTopHeadlines: GetTopHeadlines = GetTopHeadlines(
        mainDispatcher = Dispatchers.Main,
        ioDispatcher = Dispatchers.IO,
        coroutineScope = viewModelScope,
        newsRepository = newsRepository
    )
    private var selectedCategory = Category.Technology

    private val _topHeadlines = MutableLiveData<List<Article>>()
    val topHeadlines: LiveData<List<Article>> = _topHeadlines

    init {
        Log.d("HomeViewModel", "init")
        getTopHeadlines(
            params = GetTopHeadlines.Params(selectedCategory)
        ) {
            with(it) {
                onFailure { error ->
                    onGetArticleFailed(error)
                }
                onSuccess { articles ->
                    onGetArticlesSuccess(articles)
                }
            }
        }
    }

    private val onGetArticlesSuccess: (List<Article>) -> Unit = {
        Log.d("HomeViewModel", "onGetArticlesSuccess")
        _topHeadlines.postValue(it)
    }

    private val onGetArticleFailed: (Throwable) -> Unit = {
        Log.e("HomeViewModel", "onGetArticleFailed", it)
    }
}