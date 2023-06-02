package com.alife.anotherlife.ui.activity.state

import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.login.navigation.LoginNavigator
import com.alife.core.mvi.MVI

interface MainActivityEffect : MVI.Effect {

    class GoToLogin : MainActivityEffect, NavigationWrapper.Forward(LoginNavigator())
}