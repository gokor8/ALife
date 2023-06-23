package com.alife.anotherlife.core.ui.state_collector

import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.BaseNavigationWrapper
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.core.mvi.MVI

interface NavigationOnEffectCollect<EFFECT : MVI.Effect> : OnEffectCollect<EFFECT> {

    override suspend fun onEffect(navController: NavController, effect: EFFECT) {
        when(effect) {
            is BaseNavigationWrapper -> effect.navigate(navController)
        }
    }
}