package com.alife.anotherlife.core.ui.store

import com.alife.anotherlife.core.ui.state_collector.StateCollector
import com.alife.core.mvi.MVI

interface UIStore<STATE : MVI.State, EFFECT : MVI.Effect> {

    fun getStateCollector(): StateCollector<STATE>

    fun setState(state: STATE.() -> STATE)

    suspend fun setStateDebounce(delayLong: Long, state: STATE.() -> STATE)

    fun<O> getState(state: STATE.() -> O): O

    fun getState(): STATE

    suspend fun setEffect(effect: EFFECT)

    fun trySetEffect(effect: EFFECT)

}