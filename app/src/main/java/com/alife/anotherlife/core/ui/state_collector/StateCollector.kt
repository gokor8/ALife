package com.alife.anotherlife.core.ui.state_collector

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.alife.core.mvi.MVI

interface StateCollector<STATE : MVI.State> {

    @Composable
    fun collectAsState(): State<STATE>
}