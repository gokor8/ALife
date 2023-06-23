package com.alife.anotherlife.core.ui.state_collector

import androidx.navigation.NavController
import com.alife.core.mvi.MVI

interface OnEffectCollect<EFFECT : MVI.Effect> {

    suspend fun onEffect(navController: NavController, effect: EFFECT)
}