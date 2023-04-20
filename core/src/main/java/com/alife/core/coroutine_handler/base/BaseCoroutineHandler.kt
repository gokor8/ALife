package com.alife.core.coroutine_handler.base

import com.alife.core.addons.TryCatcher

interface BaseCoroutineHandler<R> {

//    suspend fun handle(action: suspend () -> R)
//
//    suspend fun <M> handle(model: M, action: suspend (M) -> R)
//
//    suspend fun <M> handleThis(model: M, action: suspend M.() -> R)


    abstract class Abstract<R>(
        protected val onException: suspend (Exception) -> R,
        protected val tryCatcher: TryCatcher<R>
    ) : BaseCoroutineHandler<R>
}