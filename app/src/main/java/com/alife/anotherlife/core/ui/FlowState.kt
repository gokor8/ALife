package com.alife.anotherlife.core.ui

import com.alife.core.mvi.MVI
import kotlinx.coroutines.flow.StateFlow

interface FlowState<STATE : MVI.State> {

    fun getFlowState(): StateFlow<STATE>

}