package com.alife.core.coroutine_handler

import com.alife.core.coroutine_handler.base.BaseCoroutineHandler
import com.alife.core.coroutine_handler.base.BaseCoroutineHandlerBuilder
import com.alife.core.mapper.Mapper

class CoroutineHandlerBuilder<M> : BaseCoroutineHandlerBuilder<M> {

    override suspend fun onException(
        action: suspend (Exception) -> M
    ): CoroutineHandler<M> = CoroutineHandler(action)

//    override suspend fun onException(mapper: Mapper<Exception, M>): BaseCoroutineHandler<M> {
//        return CoroutineHandler { exception -> mapper.map(exception) }
//    }


    override suspend fun <I> onException(
        model: I,
        action: suspend (I, Exception) -> M
    ): CoroutineHandler<M> = CoroutineHandler { exception -> action(model, exception) }

//    override suspend fun onExceptionEmpty(): BaseCoroutineHandler<Unit> = CoroutineHandler {}

//    override suspend fun <I> onExceptionThis(
//        model: I,
//        action: suspend I.(Exception) -> M
//    ): BaseCoroutineHandler<M> = CoroutineHandler { exception -> action(model, exception) }

}