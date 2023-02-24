package com.alife.anotherlife.ui.screen.registration.base.state

import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.core.mvi.MVI

interface RegistrationEffect : MVI.Effect {

    class NavigateUsername : /*NavigationWrapper.Forward(),*/ RegistrationEffect
}