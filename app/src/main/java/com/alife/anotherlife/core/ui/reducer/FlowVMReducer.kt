package com.alife.anotherlife.core.ui.reducer

import com.alife.anotherlife.core.ui.FlowState
import com.alife.core.mvi.MVI

interface FlowVMReducer<STATE : MVI.State, EFFECT : MVI.Effect> : VMReducer<STATE, EFFECT>,
    FlowState<STATE>