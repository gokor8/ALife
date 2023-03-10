package com.alife.domain.core.usecase

import com.alife.core.mapper.Mapper
import com.alife.core.usecase.UseCaseEntity
import kotlinx.coroutines.*

abstract class AbstractSafeUseCase<M : UseCaseEntity>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val exceptionMapper: Mapper<Throwable, M>,
) {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        exceptionMapper.map(throwable)
    }

    protected suspend fun withSafe(block: CoroutineScope.() -> Unit) =
        withContext(dispatcher + coroutineExceptionHandler) { block() }
}