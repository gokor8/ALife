package com.alife.anotherlife.core.ui.reducer

import com.alife.anotherlife.core.ui.state_collector.EffectCollector
import com.alife.anotherlife.core.ui.state_collector.StateCollector
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.core.mvi.MVI

abstract class BaseVMReducer<STATE : MVI.State, EFFECT : MVI.Effect> :
    VMReducer<STATE, EFFECT> {

    protected abstract val uiStore: UIStore<STATE, EFFECT>

    override fun getStateCollector(): StateCollector<STATE> = uiStore.getStateCollector()

    override fun getEffectCollector(): EffectCollector<EFFECT> = uiStore.getEffectCollector()
}