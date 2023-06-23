package com.alife.anotherlife.ui.screen.registration.base.state

import androidx.annotation.StringRes
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.ui.screen.login.navigation.LoginNavigator
import com.alife.anotherlife.ui.screen.main.create_alife.state.BaseDialogErrorEffect
import com.alife.anotherlife.ui.screen.registration.birthday.navigation.RegBirthdayNavigator
import com.alife.anotherlife.ui.screen.registration.email.navigation.RegEmailNavigator
import com.alife.anotherlife.ui.screen.registration.email_code.navigation.EmailCodeNavigator
import com.alife.anotherlife.ui.screen.registration.name.navigation.RegNameNavigator
import com.alife.anotherlife.ui.screen.registration.username.navigation.UsernameRegNavigator
import com.alife.core.mvi.MVI

interface RegistrationEffect : MVI.Effect {

    class NavigateLoginBack : NavigationWrapper.BackTo(LoginNavigator()), RegistrationEffect

    class NavigateName : NavigationWrapper.Forward(RegNameNavigator()), RegistrationEffect

    class NavigateUsername : NavigationWrapper.Forward(UsernameRegNavigator()), RegistrationEffect

    class NavigateBirthday : NavigationWrapper.Forward(RegBirthdayNavigator()), RegistrationEffect

    class NavigateEmail : NavigationWrapper.Forward(RegEmailNavigator()), RegistrationEffect

    class NavigateEmailCode : NavigationWrapper.Forward(EmailCodeNavigator()), RegistrationEffect

    class DialogError(@StringRes val text: Int) : RegistrationEffect
}