package com.alife.anotherlife.ui.screen.registration.tutorial.state

import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.main.main_screen.navigation.MainScreenNavigator
import com.alife.core.mvi.MVI

interface TutorialEffect : MVI.Effect {

    class NavigateMainScreen : TutorialEffect, NavigationWrapper.Forward(MainScreenNavigator())
}