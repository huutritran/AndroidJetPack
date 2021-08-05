package com.example.jetpack.domain.usecases

import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params>(
    private val mainDispatcher: CoroutineDispatcher,
    private val ioDispatcher: CoroutineDispatcher,
    private val coroutineScope: CoroutineScope,
) where Type : Any {

    abstract suspend fun run(params: Params): Result<Type>

    operator fun invoke(
        params: Params,
        onResult: (Result<Type>) -> Unit = {}
    ) {
        coroutineScope.launch(mainDispatcher) {
            val deferred = async(ioDispatcher) {
                run(params)
            }
            onResult(deferred.await())
        }
    }

    class None
}