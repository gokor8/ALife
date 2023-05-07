package com.alife.anotherlife.core

import com.alife.anotherlife.core.ui.state_collector.EffectCollector
import com.alife.anotherlife.core.ui.state_collector.StateCollector
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.core.mvi.MVI

class EmptyUIStore<STATE : MVI.State, EFFECT : MVI.Effect> : UIStore<STATE, EFFECT> {
    override fun getStateCollector(): StateCollector<STATE> {
        TODO("Not yet implemented")
    }

    override fun getEffectCollector(): EffectCollector<EFFECT> {
        TODO("Not yet implemented")
    }

    override fun getState(): STATE {
        TODO("Not yet implemented")
    }

    override suspend fun <O> getStateSuspend(state: suspend STATE.() -> O): O {
        TODO("Not yet implemented")
    }

    override suspend fun setStateDebounce(delayLong: Long, state: STATE.() -> STATE) {
        TODO("Not yet implemented")
    }

    override fun trySetEffect(effect: EFFECT) {
        TODO("Not yet implemented")
    }

    override suspend fun setEffect(effect: EFFECT) {
        TODO("Not yet implemented")
    }

    override fun <O> getState(state: STATE.() -> O): O {
        TODO("Not yet implemented")
    }

    override suspend fun setSuspendState(state: suspend STATE.() -> STATE) {
        TODO("Not yet implemented")
    }

    override fun setState(state: STATE) {
        TODO("Not yet implemented")
    }

    override fun setState(state: STATE.() -> STATE) {
        TODO("Not yet implemented")
    }
}