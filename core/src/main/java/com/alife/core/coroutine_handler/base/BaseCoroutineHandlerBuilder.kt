package com.alife.core.coroutine_handler.base

interface BaseCoroutineHandlerBuilder {

    suspend fun onExceptionEmpty(): BaseCoroutineHandler

    interface BaseReturnUnit : BaseCoroutineHandlerBuilder {
        suspend fun onException(action: suspend (Exception) -> Unit): BaseCoroutineHandler.BaseReturnUnit
    }

    interface BaseReturnModel : BaseCoroutineHandlerBuilder {
        suspend fun <M> onException(action: suspend (Exception) -> M): BaseCoroutineHandler.BaseReturnModel<M>
    }
}