package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state

import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.core.mvi.MVI

interface FinishVideoEffect : MVI.Effect {

    class GoBack : FinishVideoEffect, NavigationWrapper.Back()
}