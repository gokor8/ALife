package com.alife.anotherlife.ui.screen.login.state

import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.registration.name.navigation.RegNameNavigator
import com.alife.core.mvi.MVI

sealed interface LoginEffect : MVI.Effect {

    class NavigateRegistration : LoginEffect, NavigationWrapper.Forward(RegNameNavigator())
}