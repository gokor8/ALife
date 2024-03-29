package com.alife.anotherlife.ui.screen.main.finish_create_alife.base_state

import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.main.MainScreen
import com.alife.anotherlife.ui.screen.main.navigation.MainScreenNavigator
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.navigation.HomeNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.navigation.HomeNavigator
import com.alife.core.mvi.MVI

interface FinishEffect : MVI.Effect {

    class Retry : FinishEffect

    class GoBack : FinishEffect, NavigationWrapper.Back()

    class RequireGps : FinishEffect

    class GoMain : FinishEffect, NavigationWrapper.ForwardSingleInclusive(HomeNavigator())
}