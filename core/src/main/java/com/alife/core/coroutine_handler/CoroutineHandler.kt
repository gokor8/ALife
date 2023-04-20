package com.alife.core.coroutine_handler

import com.alife.core.addons.TryCatcher
import com.alife.core.coroutine_handler.base.BaseCoroutineHandler

class CoroutineHandler<R>(
    onException: suspend (Exception) -> R
) : BaseCoroutineHandler.Abstract<R>(onException, TryCatcher()),
    BaseCoroutineHandler<R> {

    override suspend fun handle(action: suspend () -> R) {
        tryCatcher.tryCatch(onException, action)
    }

    override suspend fun <M> handle(model: M, action: suspend (M) -> R) {
        tryCatcher.tryCatch(onException) { action(model) }
    }

    override suspend fun <M> handleThis(model: M, action: suspend M.() -> R) {
        tryCatcher.tryCatch(onException) { action(model) }
    }
}