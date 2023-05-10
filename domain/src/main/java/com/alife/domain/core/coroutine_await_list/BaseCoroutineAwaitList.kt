package com.alife.domain.core.coroutine_await_list

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

interface BaseCoroutineAwaitList {

    suspend fun addAndLaunch(
        scope: CoroutineScope,
        dispatcher: CoroutineDispatcher,
        block: suspend CoroutineScope.() -> Unit
    )

    suspend fun addAndLaunch(
        dispatcher: CoroutineDispatcher,
        block: suspend CoroutineScope.() -> Unit
    )

    fun isComplete(): Boolean

    suspend fun joinAll(dispatcher: CoroutineDispatcher)
}