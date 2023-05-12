package com.alife.anotherlife.core.ui.state_collector

import androidx.navigation.NavController
import com.alife.core.mvi.MVI

interface EffectCollector<EFFECT : MVI.Effect> {

    suspend fun collect(navController: NavController, onEffectCollect: OnEffectCollect<EFFECT>)
    suspend fun collect(onEffectCollect: suspend (EFFECT) -> Unit)
}