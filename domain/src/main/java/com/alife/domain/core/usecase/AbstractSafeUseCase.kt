package com.alife.domain.core.usecase

import com.alife.core.usecase.UseCaseEntity
import com.alife.domain.core.mapper.ThrowableMapper
import kotlinx.coroutines.*

abstract class AbstractSafeUseCase<M : UseCaseEntity>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val exceptionMapper: ThrowableMapper<M>,
) {
    protected suspend fun withSafe(block: CoroutineScope.() -> M) =
        withContext(dispatcher) {
            try {
                block()
            } catch (throwable: Throwable) {
                exceptionMapper.map(throwable)
            }
        }
}