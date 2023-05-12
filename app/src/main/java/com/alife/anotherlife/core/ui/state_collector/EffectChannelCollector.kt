package com.alife.anotherlife.core.ui.state_collector

import androidx.navigation.NavController
import com.alife.core.mvi.MVI
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

class EffectChannelCollector<EFFECT : MVI.Effect> @Inject constructor(
    private val effectChannel: Channel<EFFECT>
) : EffectCollector<EFFECT> {

    override suspend fun collect(
        navController: NavController,
        onEffectCollect: OnEffectCollect<EFFECT>
    ) {
        effectChannel.receiveAsFlow().onEach { effect ->
            onEffectCollect.onEffect(navController, effect)
        }.collect()
    }

    override suspend fun collect(onEffectCollect: suspend ( EFFECT) -> Unit) {
        effectChannel.receiveAsFlow().onEach { onEffectCollect(it) }.collect()
    }
}