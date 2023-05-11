package com.alife.anotherlife.core.ui.reducer

import com.alife.core.addons.TryCatcher
import com.alife.core.coroutine_handler.base.BaseCoroutineHandler
import kotlinx.coroutines.CoroutineExceptionHandler
import java.lang.Exception

class CoroutineExceptionHandler(
    private val onException: (Exception) -> Unit
) : BaseCoroutineHandler<Unit> {

    suspend fun handle(action: suspend (CoroutineExceptionHandler) -> Unit) {
        TryCatcher<Unit>().tryCatch(onException) {
            val ceh = CoroutineExceptionHandler { coroutineContext, throwable ->
                if (throwable is Exception) {
                    onException(throwable)
                }
            }
            action(ceh)
        }
    }

    suspend fun<M> handleThis(
        model: M,
        action: suspend M.(CoroutineExceptionHandler) -> Unit
    ) {
        val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            if (throwable is Exception) onException(throwable)
        }

        TryCatcher<Unit>().tryCatch(onException) {
            model.action(exceptionHandler)
        }
    }
}