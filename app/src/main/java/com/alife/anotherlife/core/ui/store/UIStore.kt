package com.alife.anotherlife.core.ui.store

import com.alife.anotherlife.core.ui.state_collector.EffectCollector
import com.alife.anotherlife.core.ui.state_collector.StateCollector
import com.alife.core.mvi.MVI
import com.alife.core.mvi.addons.BaseMVIHandlers

interface UIStore<STATE : MVI.State, EFFECT : MVI.Effect> : BaseMVIHandlers<STATE, EFFECT> {

    fun getStateCollector(): StateCollector<STATE>

    fun getEffectCollector(): EffectCollector<EFFECT>

}