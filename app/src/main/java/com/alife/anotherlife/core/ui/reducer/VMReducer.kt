package com.alife.anotherlife.core.ui.reducer

import com.alife.anotherlife.core.ui.state_collector.EffectCollector
import com.alife.anotherlife.core.ui.state_collector.StateCollector
import com.alife.core.mvi.MVI

interface VMReducer<STATE : MVI.State, EFFECT : MVI.Effect> {
    fun getState(): StateCollector<STATE>

    fun getEffect(): EffectCollector<EFFECT>
}