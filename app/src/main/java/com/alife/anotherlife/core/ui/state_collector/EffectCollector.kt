package com.alife.anotherlife.core.ui.state_collector

import com.alife.core.mvi.MVI

interface EffectCollector<EFFECT : MVI.Effect> {

    suspend fun collect(onEffectCollect: OnEffectCollect<EFFECT>)
}