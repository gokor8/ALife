package com.alife.anotherlife.core.ui.state_collector

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.alife.core.mvi.MVI
import kotlinx.coroutines.flow.StateFlow

class StateFlowCollector<STATE : MVI.State>(
    private val stateFlow: StateFlow<STATE>
) : StateCollector<STATE> {

    @Composable
    override fun collectAsState(): State<STATE> {
        return stateFlow.collectAsState()
    }
}