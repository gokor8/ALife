package com.alife.anotherlife.ui.screen.registration.username

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.ui.screen.registration.base.RegistrationScreen
import com.alife.anotherlife.ui.screen.registration.username.model.EmailDogVisualTransformation

class UsernameRegistrationScreen(
    override val navController: NavController,
) : RegistrationScreen() {//EmailDogVisualTransformation()) {

    @Composable
    override fun setupViewModel(): UsernameRegistrationVM = hiltViewModel()
}