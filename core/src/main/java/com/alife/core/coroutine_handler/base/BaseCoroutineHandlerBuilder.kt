package com.alife.core.coroutine_handler.base

import com.alife.core.coroutine_handler.CoroutineHandler
import com.alife.core.mapper.Mapper

interface BaseCoroutineHandlerBuilder<M> {

    //suspend fun onExceptionEmpty(): BaseCoroutineHandler<Unit>

    suspend fun onException(action: suspend (Exception) -> M): CoroutineHandler<M>

    //suspend fun onException(mapper: Mapper<Exception, M>): BaseCoroutineHandler<M>

    suspend fun <I> onException(model: I, action: suspend (I, Exception) -> M): CoroutineHandler<M>

    //suspend fun <I> onExceptionThis(model: I, action: suspend I.(Exception) -> M): BaseCoroutineHandler<M>

}