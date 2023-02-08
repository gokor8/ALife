package com.alife.anotherlife.core.ui.store

import com.alife.core.mvi.MVI

interface Store<STATE : MVI.State, EFFECT : MVI.Effect> {

    fun setState(state: STATE.() -> STATE)

    suspend fun setStateDebounce(delayLong: Long, state: STATE.() -> STATE)

    fun<O> getState(state: STATE.() -> O): O

    fun getState(): STATE

    suspend fun setEffect(effect: EFFECT)

    fun trySetEffect(effect: EFFECT)

}