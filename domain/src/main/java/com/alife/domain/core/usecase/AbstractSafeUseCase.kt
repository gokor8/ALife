package com.alife.domain.core.usecase

import com.alife.core.usecase.UseCaseEntity
import com.alife.domain.core.mapper.ThrowableMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class AbstractSafeUseCase<M : UseCaseEntity>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val exceptionMapper: ThrowableMapper<M>,
) {
    protected suspend fun withSafe(block: suspend CoroutineScope.() -> M): M =
        withContext(dispatcher) {
            try {
                block()
            } catch (throwable: Throwable) {
                exceptionMapper.map(throwable)
            }
        }
}