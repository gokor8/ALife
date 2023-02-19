package com.alife.anotherlife.core.ui.state_collector

import com.alife.core.mvi.MVI
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

class EffectChannelCollector<EFFECT : MVI.Effect> @Inject constructor(
    private val effectChannel: Channel<EFFECT>
) : EffectCollector<EFFECT> {

    override suspend fun collect(onEffectCollect: OnEffectCollect<EFFECT>) {
        effectChannel.receiveAsFlow().onEach { effect ->
            onEffectCollect.onEffect(effect)
        }.collect()
    }
}