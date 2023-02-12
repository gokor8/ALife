package com.alife.anotherlife.core.ui.reducer

import com.alife.anotherlife.core.ui.FlowState
import com.alife.anotherlife.core.ui.state_collector.StateCollector
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.core.mvi.MVI

abstract class BaseVMReducer<STATE : MVI.State, EFFECT : MVI.Effect> :
    VMReducer<STATE, EFFECT> {

    protected abstract val uiStore: UIStore<STATE, EFFECT>

    override fun getState(): StateCollector<STATE> = uiStore.getStateCollector()
}