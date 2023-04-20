package com.alife.anotherlife.core.ui.reducer

import com.alife.core.coroutine_handler.CoroutineHandlerBuilder
import com.alife.core.coroutine_handler.base.BaseCoroutineHandler
import com.alife.core.mapper.Mapper
import kotlin.Exception

interface CoroutineHandlerBuilders {

    suspend fun <M> execute(): CoroutineHandlerBuilder<M>

    suspend fun executeUnit(): CoroutineHandlerBuilder<Unit>

    suspend fun <M> execute(onException: (Exception) -> M): BaseCoroutineHandler<M>

    suspend fun <M> execute(exceptionMapper: Mapper<Exception, M>): BaseCoroutineHandler<M>

    suspend fun <I, M> execute(model: I, onException: (I, Exception) -> M): BaseCoroutineHandler<M>

    suspend fun <I, M> executeThis(model: I, onException: I.(Exception) -> M): BaseCoroutineHandler<M>

    class Default : CoroutineHandlerBuilders {
        override suspend fun <M> execute(): CoroutineHandlerBuilder<M> {
            return CoroutineHandlerBuilder()
        }

        override suspend fun <M> execute(onException: (Exception) -> M): BaseCoroutineHandler<M> {
            return CoroutineHandlerBuilder<M>().onException(onException)
        }

        override suspend fun <M> execute(exceptionMapper: Mapper<Exception, M>): BaseCoroutineHandler<M> {
            return CoroutineHandlerBuilder<M>().onException(exceptionMapper)
        }

        override suspend fun <I, M> execute(
            model: I,
            onException: (I, Exception) -> M
        ): BaseCoroutineHandler<M> {
            return CoroutineHandlerBuilder<M>().onException(model, onException)
        }

        override suspend fun executeUnit(): CoroutineHandlerBuilder<Unit> {
            return CoroutineHandlerBuilder()
        }

        override suspend fun <I, M> executeThis(
            model: I,
            onException: (I, Exception) -> M
        ): BaseCoroutineHandler<M> {
            return CoroutineHandlerBuilder<M>().onExceptionThis(model, onException)
        }
    }
}