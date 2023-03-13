package com.alife.domain.core.usecase

import com.alife.core.usecase.UseCaseEntity
import com.alife.domain.core.mapper.ThrowableMapper
import kotlinx.coroutines.*

abstract class AbstractSafeUseCase<M : UseCaseEntity>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val exceptionMapper: ThrowableMapper<UseCaseResult<M>>,
) {
    protected suspend fun withSafe(block: suspend CoroutineScope.() -> M): UseCaseResult<M> =
        withContext(dispatcher) {
            try {
                val result = block()
                UseCaseResult.Success(result)
            } catch (throwable: Throwable) {
                exceptionMapper.map(throwable)
            }
        }
}