package com.alife.core.coroutine_handler

import com.alife.core.addons.TryCatcher
import com.alife.core.coroutine_handler.base.BaseCoroutineHandler

class UnitCoroutineHandler(
    onException: suspend (Exception) -> Unit
) : BaseCoroutineHandler.Abstract<Unit>(onException, TryCatcher()),
    BaseCoroutineHandler.BaseReturnUnit {

    override suspend fun handle(action: suspend () -> Unit) {
        tryCatcher.tryCatch(onException, action)
    }

    override suspend fun <M> handle(model: M, action: suspend (M) -> Unit) {
        tryCatcher.tryCatch(onException) { action(model) }
    }

    override suspend fun <M> handleThis(model: M, action: suspend M.() -> Unit) {
        tryCatcher.tryCatch(onException) { action(model) }
    }
}