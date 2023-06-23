package com.alife.anotherlife.ui.screen.registration.username

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.ui.screen.registration.base.RegistrationScreen

class UsernameRegistrationScreen(
    override val navController: NavController,
) : RegistrationScreen<UsernameRegistrationVM>(UsernameRegTextModel()) {

    @Composable
    override fun setupViewModel(): UsernameRegistrationVM = hiltViewModel()
}