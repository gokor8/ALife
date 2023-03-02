package com.alife.anotherlife.ui.screen.registration.email

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.ui.screen.registration.base.RegistrationScreen

class EmailRegistrationScreen(
    override val navController: NavController
) : RegistrationScreen() {

    @Composable
    override fun setupViewModel(): EmailRegistrationVM = hiltViewModel()
}