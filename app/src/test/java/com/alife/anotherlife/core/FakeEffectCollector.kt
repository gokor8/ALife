package com.alife.anotherlife.core

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.alife.anotherlife.core.ui.state_collector.EffectCollector
import com.alife.anotherlife.core.ui.state_collector.OnEffectCollect
import com.alife.core.mvi.MVI

class FakeEffectCollector<EFFECT : MVI.Effect> : EffectCollector<EFFECT> {

    override suspend fun collect(
        navController: NavController,
        onEffectCollect: OnEffectCollect<EFFECT>,
    ) {}

    override suspend fun collect(onEffectCollect: suspend (EFFECT) -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun collect(lifecycle: Lifecycle, onEffectCollect: suspend (EFFECT) -> Unit) {
        TODO("Not yet implemented")
    }
}