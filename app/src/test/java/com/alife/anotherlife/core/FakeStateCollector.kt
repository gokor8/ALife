package com.alife.anotherlife.core

import androidx.compose.runtime.*
import com.alife.anotherlife.core.ui.state_collector.StateCollector
import com.alife.core.mvi.MVI

class FakeStateCollector<STATE : MVI.State>(
    private val list: List<STATE>,
) : StateCollector<STATE> {

    @Composable
    override fun collectAsState(): State<STATE> {
        return object : State<STATE> {
            override val value: STATE = list.first()
        }
    }
}