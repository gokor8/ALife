package com.alife.anotherlife.ui.screen.registration.base.state

import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import com.alife.anotherlife.ui.screen.registration.birthday.navigation.RegBirthdayNavigator
import com.alife.anotherlife.ui.screen.registration.email.EmailRegistrationScreen
import com.alife.anotherlife.ui.screen.registration.email.navigation.RegEmailNavigator
import com.alife.anotherlife.ui.screen.registration.username.navigation.UsernameRegNavigator
import com.alife.core.mvi.MVI

interface RegistrationEffect : MVI.Effect {

    class NavigateUsername : NavigationWrapper.Forward(UsernameRegNavigator()), RegistrationEffect

    class NavigateBirthday : NavigationWrapper.Forward(RegBirthdayNavigator()), RegistrationEffect

    class NavigateEmail : NavigationWrapper.Forward(RegEmailNavigator()), RegistrationEffect

    class NavigateSmsCode : RegistrationEffect
}