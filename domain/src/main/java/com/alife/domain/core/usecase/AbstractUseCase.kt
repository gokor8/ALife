package com.alife.domain.core.usecase

import com.alife.core.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext

abstract class AbstractUseCase : UseCase {

    protected abstract val dispatcher: CoroutineDispatcher

    protected suspend fun <R> withIO(block: suspend CoroutineScope.() -> R): R {
        return withContext(dispatcher) {
            block()
        }
    }
}