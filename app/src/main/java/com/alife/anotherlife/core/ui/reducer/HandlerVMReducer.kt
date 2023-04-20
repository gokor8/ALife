package com.alife.anotherlife.core.ui.reducer

import com.alife.core.coroutine_handler.CoroutineHandler
import com.alife.core.coroutine_handler.CoroutineHandlerBuilder
import com.alife.core.mapper.Mapper
import com.alife.core.mvi.MVI

abstract class HandlerVMReducer<STATE : MVI.State, EFFECT : MVI.Effect>(
    private val coroutineHandlerBuilder: CoroutineHandlerBuilders = CoroutineHandlerBuilders.Default()
) : BaseVMReducer<STATE, EFFECT>(), CoroutineHandlerBuilders {

    override suspend fun <M> execute(): CoroutineHandlerBuilder<M> {
        return coroutineHandlerBuilder.execute()
    }

    override suspend fun executeUnit(): CoroutineHandlerBuilder<Unit> {
        return coroutineHandlerBuilder.executeUnit()
    }

    override suspend fun <M> execute(onException: suspend (Exception) -> M): CoroutineHandler<M> {
        return coroutineHandlerBuilder.execute(onException)
    }

    override suspend fun <M> execute(exceptionMapper: Mapper<Exception, M>): CoroutineHandler<M> {
        return coroutineHandlerBuilder.execute(exceptionMapper)
    }

    override suspend fun <I, M> execute(
        model: I,
        onException: suspend (I, Exception) -> M
    ): CoroutineHandler<M> = coroutineHandlerBuilder.execute(model, onException)

    override suspend fun <I, M> executeThis(
        model: I,
        onException: suspend I.(Exception) -> M
    ): CoroutineHandler<M> = coroutineHandlerBuilder.executeThis(model, onException)

    override suspend fun <STATE : MVI.State> executeWithReducer(
        reducer: BaseVMReducer<STATE, *>,
        onException: suspend STATE.(Exception) -> STATE
    ): ReducerCoroutineHandler<STATE> = coroutineHandlerBuilder.executeWithReducer(reducer, onException)
}