package com.alife.anotherlife.ui.screen.registration.birthday

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.text.text_formation.MaskVisualTransformation
import com.alife.anotherlife.core.composable.text.text_formation.mask.patterns.BirthdayPattern
import com.alife.anotherlife.ui.screen.registration.base.RegistrationScreen

class BirthdayRegistrationScreen(
    override val navController: NavController,
) : RegistrationScreen(MaskVisualTransformation(BirthdayPattern().birthdayMask)) {

    @Composable
    override fun setupViewModel(): BirthdayRegistrationVM = hiltViewModel()
}