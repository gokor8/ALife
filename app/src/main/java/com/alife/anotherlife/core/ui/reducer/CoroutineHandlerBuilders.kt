package com.alife.anotherlife.core.ui.reducer

import com.alife.core.coroutine_handler.CoroutineHandler
import com.alife.core.coroutine_handler.CoroutineHandlerBuilder
import com.alife.core.mapper.Mapper
import com.alife.core.mvi.MVI
import kotlin.Exception

interface CoroutineHandlerBuilders {

    suspend fun <M> execute(): CoroutineHandlerBuilder<M>

    suspend fun executeUnit(): CoroutineHandlerBuilder<Unit>

    suspend fun <M> execute(onException: suspend (Exception) -> M): CoroutineHandler<M>

    suspend fun <M> execute(exceptionMapper: Mapper<Exception, M>): CoroutineHandler<M>

    suspend fun <I, M> execute(
        model: I,
        onException: suspend (I, Exception) -> M
    ): CoroutineHandler<M>

    suspend fun <I, M> executeThis(
        model: I,
        onException: suspend I.(Exception) -> M
    ): CoroutineHandler<M>

    suspend fun <STATE : MVI.State> executeWithReducer(
        reducer: AbstractVMReducer<STATE, *>,
        onException: suspend STATE.(Exception) -> STATE,
    ): ReducerCoroutineHandler<STATE>


    class Default : CoroutineHandlerBuilders {
        override suspend fun <M> execute(): CoroutineHandlerBuilder<M> {
            return CoroutineHandlerBuilder()
        }

        override suspend fun executeUnit(): CoroutineHandlerBuilder<Unit> {
            return CoroutineHandlerBuilder()
        }

        override suspend fun <M> execute(onException: suspend (Exception) -> M): CoroutineHandler<M> {
            return CoroutineHandlerBuilder<M>().onException(onException)
        }

        override suspend fun <M> execute(
            exceptionMapper: Mapper<Exception, M>
        ) = CoroutineHandlerBuilder<M>().onException { exception ->
            exceptionMapper.map(exception)
        }

        override suspend fun <I, M> execute(
            model: I,
            onException: suspend (I, Exception) -> M
        ) = CoroutineHandlerBuilder<M>().onException(model, onException)

        override suspend fun <I, M> executeThis(
            model: I,
            onException: suspend I.(Exception) -> M
        ) = CoroutineHandlerBuilder<M>().onException(model, onException)

        override suspend fun <STATE : MVI.State> executeWithReducer(
            reducer: AbstractVMReducer<STATE, *>,
            onException: suspend STATE.(Exception) -> STATE,
        ) = ReducerCoroutineHandler(reducer) { exception ->
            reducer.getState().onException(exception)
        }
    }
}