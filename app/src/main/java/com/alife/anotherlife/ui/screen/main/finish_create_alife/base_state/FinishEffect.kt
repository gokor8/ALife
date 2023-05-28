package com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state

import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.core.mvi.MVI

interface FinishEffect : MVI.Effect {

    class Retry : FinishEffect

    class GoBack : FinishEffect, NavigationWrapper.Back()
}