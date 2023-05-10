package com.alife.domain.core.coroutine_await_list

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CoroutineAwaitList @Inject constructor(
    vararg job: Job
) : ArrayList<Job>(job.toList()), BaseCoroutineAwaitList {

    override suspend fun addAndLaunch(
        scope: CoroutineScope,
        dispatcher: CoroutineDispatcher,
        block: suspend CoroutineScope.() -> Unit
    ) { add(scope.launch(block = block)) }

    override suspend fun addAndLaunch(
        dispatcher: CoroutineDispatcher,
        block: suspend CoroutineScope.() -> Unit
    ) {
        withContext(dispatcher) { add(launch(block = block)) }
    }

    override fun isComplete(): Boolean = all { it.isCompleted }

    override suspend fun joinAll(dispatcher: CoroutineDispatcher) {
        withContext(dispatcher) { joinAll() }
    }
}