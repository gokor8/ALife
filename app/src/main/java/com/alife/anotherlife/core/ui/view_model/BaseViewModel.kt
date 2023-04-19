package com.alife.anotherlife.core.ui.view_model

import androidx.compose.runtime.Composable
import com.alife.anotherlife.core.ui.state_collector.NavigationOnEffectCollect
import com.alife.core.mvi.MVI
import com.alife.core.mvi.MVIReducer

interface BaseViewModel<ACTION : MVI.Action, STATE : MVI.State, EFFECT : MVI.Effect>
    : MVIReducer.Base<ACTION>, NavigationOnEffectCollect<EFFECT> {

    @Composable
    fun getUIState(): STATE
}