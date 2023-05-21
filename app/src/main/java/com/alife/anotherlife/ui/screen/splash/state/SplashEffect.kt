package com.alife.anotherlife.ui.screen.splash.state

import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.login.navigation.LoginNavigator
import com.alife.anotherlife.ui.screen.main.navigation.MainScreenNavigator
import com.alife.core.mvi.MVI

interface SplashEffect : MVI.Effect {

    class NavigateToLogin : SplashEffect, NavigationWrapper.Forward(LoginNavigator())

    class NavigateToMain : SplashEffect, NavigationWrapper.Forward(MainScreenNavigator())
}