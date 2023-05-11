package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state

import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.navigation.CreateAlifeNavigator
import com.alife.core.mvi.MVI

interface HomeChildEffect : MVI.Effect {

    class NavigateToTakeALife : HomeChildEffect, NavigationWrapper.Forward(CreateAlifeNavigator())
}