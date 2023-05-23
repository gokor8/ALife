package com.alife.anotherlife.ui.screen.registration.email_code.state

import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.registration.tutorial.navigation.TutorialNavigator
import com.alife.core.mvi.MVI

interface EmailCodeEffect : MVI.Effect {
    class NavigateTutorial : EmailCodeEffect, NavigationWrapper.Forward(TutorialNavigator())

    class GoBack : EmailCodeEffect, NavigationWrapper.Back()
}