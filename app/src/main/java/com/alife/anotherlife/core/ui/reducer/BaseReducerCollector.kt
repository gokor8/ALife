package com.alife.anotherlife.core.ui.reducer

import com.alife.anotherlife.core.ui.state_collector.EffectCollector
import com.alife.anotherlife.core.ui.state_collector.StateCollector
import com.alife.core.mvi.MVI

interface BaseReducerCollector<STATE : MVI.State, EFFECT : MVI.Effect> {

    fun getStateCollector(): StateCollector<STATE>

    fun getEffectCollector(): EffectCollector<EFFECT>
}