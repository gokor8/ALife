package com.alife.anotherlife.ui.screen.registration.username

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.alife.anotherlife.ui.screen.registration.base.RegistrationScreen
import com.alife.anotherlife.ui.screen.registration.base.RegistrationViewModel

class UsernameRegistrationScreen(override val navController: NavController) : RegistrationScreen() {

    @Composable
    override fun setupViewModel(): RegistrationViewModel {

    }
}