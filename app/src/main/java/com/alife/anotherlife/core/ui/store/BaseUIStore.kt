package com.alife.anotherlife.core.ui.store

import com.alife.anotherlife.core.ui.state_collector.StateCollector
import com.alife.anotherlife.core.ui.state_collector.StateFlowCollector
import com.alife.core.mvi.MVI
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect

abstract class BaseUIStore<STATE : MVI.State, EFFECT : MVI.Effect>(
    initState: STATE
) : UIStore<STATE, EFFECT> {

    val stateFlow: MutableStateFlow<STATE> = MutableStateFlow(initState)

    protected val effectChannel: Channel<EFFECT> = Channel()


    override fun getStateCollector(): StateCollector<STATE> {
        return StateFlowCollector(stateFlow)
    }

    override fun getState(): STATE = stateFlow.value

    override fun <O> getState(state: STATE.() -> O): O {
        return state(getState())
    }

    override suspend fun setStateDebounce(delayLong: Long, state: STATE.() -> STATE) {
        delay(delayLong)
        stateFlow.value = getState().state()
    }

    override fun setState(state: STATE.() -> STATE) {
        stateFlow.value = getState().state()
    }

    override fun setState(state: STATE) {
        stateFlow.value = state
    }

    override suspend fun setEffect(effect: EFFECT) {
        effectChannel.send(effect)
    }

    override fun trySetEffect(effect: EFFECT) {
        effectChannel.trySend(effect)
    }
}