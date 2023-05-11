package com.alife.domain.core.coroutine_await_list

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class CoroutineAwaitList @Inject constructor(
    vararg job: Job
) : ArrayList<Job>(job.toList()), BaseCoroutineAwaitList {

    override suspend fun addAndLaunch(
        scope: CoroutineScope,
        coroutineContext: CoroutineContext,
        block: suspend CoroutineScope.() -> Unit
    ) { add(scope.launch(coroutineContext, block = block)) }

    override suspend fun addAndLaunch(
        coroutineContext: CoroutineContext,
        block: suspend CoroutineScope.() -> Unit
    ) {
        withContext(coroutineContext) { add(launch(block = block)) }
    }

    override fun isComplete(): Boolean = all { it.isCompleted }

    override suspend fun joinAll(dispatcher: CoroutineDispatcher) {
        withContext(dispatcher) { joinAll() }
    }
}