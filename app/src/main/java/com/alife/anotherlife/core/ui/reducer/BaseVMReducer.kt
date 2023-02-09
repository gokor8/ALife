package com.alife.anotherlife.core.ui.reducer

import com.alife.anotherlife.core.ui.FlowState
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.core.mvi.MVI
import kotlinx.coroutines.flow.StateFlow

abstract class BaseVMReducer<STATE : MVI.State, EFFECT : MVI.Effect> :
    VMReducer<STATE, EFFECT>, FlowState<STATE> {

    protected abstract val uiStore: UIStore<STATE, EFFECT>
}