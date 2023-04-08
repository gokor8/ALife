package com.alife.core.mvi.addons

import com.alife.core.mvi.MVI

interface BaseMVIHandlers<STATE : MVI.State, EFFECT : MVI.Effect> {

    fun setState(state: STATE.() -> STATE)
    fun setState(state: STATE)

    fun<O> getState(state: STATE.() -> O): O

    fun getState(): STATE

    suspend fun setEffect(effect: EFFECT)

    fun trySetEffect(effect: EFFECT)
}