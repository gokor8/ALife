package com.alife.core.coroutine_handler

import com.alife.core.addons.TryCatcher
import com.alife.core.coroutine_handler.base.BaseCoroutineHandler

class CoroutineHandler<R>(
    onException: suspend (Exception) -> R
) : BaseCoroutineHandler.Abstract<R>(onException, TryCatcher()),
    BaseCoroutineHandler<R> {

    suspend fun handle(action: suspend () -> R): R {
        return tryCatcher.tryCatch(onException, action)
    }

    suspend fun <M> handle(model: M, action: suspend (M) -> R) {
        tryCatcher.tryCatch(onException) { action(model) }
    }

    suspend fun <M> handleThis(model: M, action: suspend M.() -> R): R {
        return tryCatcher.tryCatch(onException) { action(model) }
    }
}