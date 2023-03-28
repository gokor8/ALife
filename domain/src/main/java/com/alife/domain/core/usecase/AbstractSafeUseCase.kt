package com.alife.domain.core.usecase

import com.alife.core.usecase.UseCaseEntity
import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.core.mapper.ThrowableUCMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

sealed class AbstractSafeUseCase<M>(
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


    abstract class Entity<M : UseCaseEntity>(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        exceptionMapper: ThrowableUCMapper<M>,
    ) : AbstractSafeUseCase<M>(dispatcher, exceptionMapper)

    abstract class Empty(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        exceptionMapper: ThrowableUCMapper<Unit>,
    ) : AbstractSafeUseCase<Unit>(dispatcher, exceptionMapper)
}