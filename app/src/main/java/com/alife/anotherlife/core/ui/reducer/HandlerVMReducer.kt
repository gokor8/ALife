package com.alife.anotherlife.core.ui.reducer

import com.alife.core.coroutine_handler.CoroutineHandlerBuilder
import com.alife.core.coroutine_handler.base.BaseCoroutineHandler
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

    override suspend fun <M> execute(onException: (Exception) -> M): BaseCoroutineHandler<M> {
        return coroutineHandlerBuilder.execute(onException)
    }

    override suspend fun <M> execute(exceptionMapper: Mapper<Exception, M>): BaseCoroutineHandler<M> {
        return coroutineHandlerBuilder.execute(exceptionMapper)
    }

    override suspend fun <I, M> execute(
        model: I,
        onException: (I, Exception) -> M
    ): BaseCoroutineHandler<M> {
        return coroutineHandlerBuilder.execute(model, onException)
    }

    override suspend fun <I, M> executeThis(
        model: I,
        onException: I.(Exception) -> M
    ): BaseCoroutineHandler<M> {
        return coroutineHandlerBuilder.executeThis(model, onException)
    }
}