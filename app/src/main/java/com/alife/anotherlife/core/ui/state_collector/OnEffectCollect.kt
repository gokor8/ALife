package com.alife.anotherlife.core.ui.state_collector

import com.alife.core.mvi.MVI

interface OnEffectCollect<EFFECT : MVI.Effect> {

    fun onEffect(effect: EFFECT)
}