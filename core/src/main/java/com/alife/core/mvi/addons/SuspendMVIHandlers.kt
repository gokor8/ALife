package com.alife.core.mvi.addons

import com.alife.core.mvi.MVI

interface SuspendMVIHandlers<STATE : MVI.State, EFFECT : MVI.Effect> {

    suspend fun setStateDebounce(delayLong: Long, state: STATE.() -> STATE)

    suspend fun <O> getStateSuspend(state: suspend STATE.() -> O): O
}