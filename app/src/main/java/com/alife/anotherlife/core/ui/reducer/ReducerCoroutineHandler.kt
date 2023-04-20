package com.alife.anotherlife.core.ui.reducer

import com.alife.core.addons.TryCatcher
import com.alife.core.coroutine_handler.base.BaseCoroutineHandler
import com.alife.core.mvi.MVI
import java.lang.Exception

class ReducerCoroutineHandler<STATE : MVI.State>(
    private val reducer: BaseVMReducer<STATE, *>,
    onException: suspend (Exception) -> STATE
) : BaseCoroutineHandler.Abstract<STATE>(onException, TryCatcher()),
    BaseCoroutineHandler<STATE> {

    suspend fun handle(action: suspend STATE.() -> STATE) {
        val newState = tryCatcher.tryCatch(onException) { reducer.getState().action() }
        reducer.setState(newState)
    }
}