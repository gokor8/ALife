package com.alife.core.coroutine_handler

import com.alife.core.coroutine_handler.base.BaseCoroutineHandler
import com.alife.core.coroutine_handler.base.BaseCoroutineHandlerBuilder

class UnitCoroutineHandlerBuilder : BaseCoroutineHandlerBuilder.BaseReturnUnit {

    override suspend fun onException(
        action: suspend (Exception) -> Unit
    ): BaseCoroutineHandler.BaseReturnUnit {
        return UnitCoroutineHandler(action)
    }

    override suspend fun onExceptionEmpty(): BaseCoroutineHandler {
        return UnitCoroutineHandler {}
    }
}