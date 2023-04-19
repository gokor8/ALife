package com.alife.anotherlife.core.ui.reducer

import com.alife.core.mapper.Mapper
import com.alife.core.mvi.MVI
import com.alife.core.mvi.addons.BaseMVIHandlers
import java.lang.Exception

abstract class HandleLaunch {

    protected suspend fun <R> handleExecute(
        exception: suspend (Exception) -> R,
        action: suspend () -> R,
    ): R = try {
        action()
    } catch (e: Exception) {
        exception(e)
    }

    protected suspend fun <R> handleExecute(
        exception: Mapper<Exception, R>,
        action: suspend () -> R,
    ): R = try {
        action()
    } catch (e: Exception) {
        exception.map(e)
    }

//    protected suspend fun <STATE : MVI.State> BaseMVIHandlers<STATE, *>.handleExecuteState(
//        exception: suspend STATE.(Exception) -> STATE,
//        action: suspend STATE.() -> STATE,
//    ): Unit = setSuspendState {
//        try {
//            action()
//        } catch (e: Exception) {
//            exception(e)
//        }
//    }

    protected suspend fun <STATE : MVI.State> BaseMVIHandlers<STATE, *>.handleExecuteState(
        exception: suspend STATE.(Exception) -> STATE,
        action: suspend STATE.() -> Unit,
    ): Unit = try {
        getState().action()
    } catch (e: Exception) {
        setSuspendState { exception(e) }
    }

    protected suspend fun <STATE : MVI.State> BaseMVIHandlers<STATE, *>.handleExecuteState(
        action: suspend STATE.() -> Unit,
    ): StateExceptionHandler<STATE> {
        try {
            getState().action()
        } catch (e: Exception) {
            setSuspendState { exception(e) }
        }

        return StateExceptionHandler()
    }
}

class ReturnStateExceptionHandler<STATE : MVI.State> {
    suspend fun STATE.onException(
        exception: Exception,
        onException: suspend STATE.(Exception) -> STATE
    ) {
        onException(exception)
    }
}

class StateExceptionHandler<STATE : MVI.State> {
    suspend fun onException(
        handlers: BaseMVIHandlers<STATE, *>,

    ) {

    }

    suspend fun STATE.onException(
        exception: Exception,
        onException: suspend STATE.(Exception) -> STATE
    ) {
        onException(exception)
    }
}

interface UnitExceptionHandler {

}

interface GenericExceptionHandler {

}