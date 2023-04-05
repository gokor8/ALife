package com.alife.domain.core.usecase

import com.alife.core.usecase.UseCaseEntity
import com.alife.domain.core.mapper.ThrowableMapper
import kotlinx.coroutines.*

abstract class AbstractSafeUseCaseResult<M>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val exceptionMapper: ThrowableMapper<UseCaseResult<M>>,
) {

    protected open fun onSuccess(result: M): UseCaseResult.BaseSuccess<M> {
        return UseCaseResult.Success(result)
    }

    protected suspend fun withSafe(block: suspend CoroutineScope.() -> M): UseCaseResult<M> =
        withContext(dispatcher) {
            try {
                val result = block()
                onSuccess(result)
            } catch (throwable: Throwable) {
                exceptionMapper.map(throwable)
            }
        }
}