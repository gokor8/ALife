package com.alife.anotherlife.core.ui.reducer

import com.alife.anotherlife.core.ui.state_collector.EffectCollector
import com.alife.anotherlife.core.ui.state_collector.StateCollector
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.core.coroutine_handler.CoroutineHandlerBuilder
import com.alife.core.coroutine_handler.base.BaseCoroutineHandler
import com.alife.core.coroutine_handler.base.BaseCoroutineHandlerBuilder
import com.alife.core.mvi.MVI
import com.alife.core.mvi.addons.BaseMVIHandlers
import com.alife.core.mvi.addons.SuspendMVIHandlers

abstract class BaseVMReducer<STATE : MVI.State, EFFECT : MVI.Effect> : VMReducer<STATE, EFFECT>,
    BaseMVIHandlers<STATE, EFFECT>, SuspendMVIHandlers<STATE, EFFECT> {

    protected abstract val uiStore: UIStore<STATE, EFFECT>

    override fun getStateCollector(): StateCollector<STATE> = uiStore.getStateCollector()

    override fun getEffectCollector(): EffectCollector<EFFECT> = uiStore.getEffectCollector()

    override fun setState(state: STATE.() -> STATE) {
        uiStore.getState {
            uiStore.setState(state())
        }
    }

    override fun setState(state: STATE) {
        uiStore.setState(state)
    }

    override suspend fun setSuspendState(state: suspend STATE.() -> STATE) {
        uiStore.setSuspendState(state)
    }

    override suspend fun setStateDebounce(delayLong: Long, state: STATE.() -> STATE) {
        uiStore.setStateDebounce(delayLong, state)
    }

    override fun <O> getState(state: STATE.() -> O): O = uiStore.getState(state)

    override suspend fun <O> getStateSuspend(state: suspend STATE.() -> O) =
        uiStore.getStateSuspend(state)

    override fun getState(): STATE = uiStore.getState()

    override fun trySetEffect(effect: EFFECT) {
        uiStore.trySetEffect(effect)
    }

    override suspend fun setEffect(effect: EFFECT) {
        uiStore.setEffect(effect)
    }
}