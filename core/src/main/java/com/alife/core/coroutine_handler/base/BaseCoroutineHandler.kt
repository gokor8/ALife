package com.alife.core.coroutine_handler.base

import com.alife.core.addons.TryCatcher

interface BaseCoroutineHandler {

    interface BaseReturnUnit : BaseCoroutineHandler {
        suspend fun handle(action: suspend () -> Unit)

        suspend fun <M> handle(model: M, action: suspend (M) -> Unit)

        suspend fun <M> handleThis(model: M, action: suspend M.() -> Unit)
    }

    interface BaseReturnModel<R> : BaseCoroutineHandler {
        suspend fun handle(action: suspend () -> R)

        suspend fun <M> handle(model: M, action: suspend (M) -> R)

        suspend fun <M> handleThis(model: M, action: suspend M.() -> R)
    }

    abstract class Abstract<R>(
        protected val onException: suspend (Exception) -> R,
        protected val tryCatcher: TryCatcher<R>
    ) : BaseCoroutineHandler
}