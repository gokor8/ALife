package com.alife.anotherlife.core

import com.alife.anotherlife.core.ui.state_collector.EffectCollector
import com.alife.anotherlife.core.ui.state_collector.StateCollector
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.core.mvi.MVI

class FakeUIStore<STATE : MVI.State, EFFECT : MVI.Effect>(initState: STATE) : UIStore<STATE, EFFECT> {

    val stateCollector: MutableList<STATE> = mutableListOf(initState)
    val effectCollector: MutableList<EFFECT> = mutableListOf()

    private val fakeStateCollector = FakeStateCollector(stateCollector)
    private val fakeEffectCollector = FakeEffectCollector<EFFECT>()


    override fun getStateCollector(): StateCollector<STATE> = fakeStateCollector
    override fun getEffectCollector(): EffectCollector<EFFECT> = fakeEffectCollector

    override fun getState(): STATE {
        return stateCollector.last()
    }

    override suspend fun <O> getStateSuspend(state: suspend STATE.() -> O): O {
        return stateCollector.last().state()
    }

    override fun trySetEffect(effect: EFFECT) {
        effectCollector.add(effect)
    }

    override suspend fun setEffect(effect: EFFECT) {
        effectCollector.add(effect)
    }

    override fun <O> getState(state: STATE.() -> O): O {
        return stateCollector.last().state()
    }

    override suspend fun setStateDebounce(delayLong: Long, state: STATE.() -> STATE) {
        stateCollector.add(getState().state())
    }

    override fun setState(state: STATE) {
        stateCollector.add(state)
    }

    override fun setState(state: STATE.() -> STATE) {
        stateCollector.add(getState().state())
    }

    override suspend fun setSuspendState(state: suspend STATE.() -> STATE) {
        stateCollector.add(getState().state())
    }
}