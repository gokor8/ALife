package com.alife.anotherlife.ui.screen.registration.base.state

import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.registration.birthday.navigation.RegBirthdayNavigator
import com.alife.anotherlife.ui.screen.registration.username.navigation.UsernameRegNavigator
import com.alife.core.mvi.MVI

interface RegistrationEffect : MVI.Effect {

    class NavigateUsername : NavigationWrapper.Forward(UsernameRegNavigator()), RegistrationEffect

    class NavigateBirthday : NavigationWrapper.Forward(RegBirthdayNavigator()), RegistrationEffect

    class NavigateEmail : RegistrationEffect
}