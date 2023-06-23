package com.alife.anotherlife.core.ui.reducer

import com.alife.anotherlife.core.ui.FlowState
import com.alife.core.mvi.MVI

interface FlowBaseVMReducer<STATE : MVI.State, EFFECT : MVI.Effect> : BaseVMReducer<STATE, EFFECT>,
    FlowState<STATE>