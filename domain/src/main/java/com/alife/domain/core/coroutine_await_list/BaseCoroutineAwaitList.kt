package com.alife.domain.core.coroutine_await_list

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

interface BaseCoroutineAwaitList {

    suspend fun addAndLaunch(
        scope: CoroutineScope,
        coroutineContext: CoroutineContext,
        block: suspend CoroutineScope.() -> Unit
    )

    suspend fun addAndLaunch(
        coroutineContext: CoroutineContext,
        block: suspend CoroutineScope.() -> Unit
    )

    fun isComplete(): Boolean

    suspend fun joinAll(dispatcher: CoroutineDispatcher)
}