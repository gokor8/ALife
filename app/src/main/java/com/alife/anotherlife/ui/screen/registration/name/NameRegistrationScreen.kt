package com.alife.anotherlife.ui.screen.registration.name

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.ui.screen.registration.base.RegistrationScreen

class NameRegistrationScreen(
    override val navController: NavController,
) : RegistrationScreen() {

    @Composable
    override fun setupViewModel(): NameRegistrationVM = hiltViewModel()
}