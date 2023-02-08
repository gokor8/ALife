package com.alife.anotherlife.core.ui.store

import com.alife.core.mvi.MVI
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseStore<STATE : MVI.State, EFFECT : MVI.Effect> : Store<STATE, EFFECT> {

    abstract val initState: STATE

    protected val stateFlow: MutableStateFlow<STATE> = MutableStateFlow(initState)

    protected val effectChannel: Channel<EFFECT> = Channel()


    override fun getState(): STATE = stateFlow.value

    override fun <O> getState(state: STATE.() -> O): O {
        return state(getState())
    }

    override suspend fun setStateDebounce(delayLong: Long, state: STATE.() -> STATE) {
        delay(delayLong)
        state(getState())
    }

    override fun setState(state: STATE.() -> STATE) {
        state(getState())
    }

    override suspend fun setEffect(effect: EFFECT) {
        effectChannel.send(effect)
    }

    override fun trySetEffect(effect: EFFECT) {
        effectChannel.trySend(effect)
    }
}