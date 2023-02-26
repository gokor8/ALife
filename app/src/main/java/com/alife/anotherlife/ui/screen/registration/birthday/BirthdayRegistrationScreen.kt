package com.alife.anotherlife.ui.screen.registration.birthday

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.ui.screen.registration.base.RegistrationScreen

class BirthdayRegistrationScreen(
    override val navController: NavController,
) : RegistrationScreen(BirthdayRegTextModel()) {

    @Composable
    override fun setupViewModel(): BirthdayRegistrationVM = hiltViewModel()
}