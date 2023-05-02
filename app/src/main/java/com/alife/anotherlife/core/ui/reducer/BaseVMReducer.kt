package com.alife.anotherlife.core.ui.reducer

import com.alife.anotherlife.core.ui.state_collector.EffectCollector
import com.alife.anotherlife.core.ui.state_collector.StateCollector
import com.alife.core.mvi.MVI
import com.alife.core.mvi.addons.BaseMVIHandlers
import com.alife.core.mvi.addons.SuspendMVIHandlers

interface BaseVMReducer<STATE : MVI.State, EFFECT : MVI.Effect> {

    fun getStateCollector(): StateCollector<STATE>

    fun getEffectCollector(): EffectCollector<EFFECT>
}