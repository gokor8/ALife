package com.alife.anotherlife.ui.screen.registration.email_code.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.registration.email_code.EmailCodeRegistrationScreen

class EmailCodeNavBuilder(
    private val navController: NavController
) : NewDefaultNavBuilder(EmailCodeNavRoute()) {

    @Composable
    override fun Content(navBackStackEntry: NavBackStackEntry) {
        EmailCodeRegistrationScreen(navController).SetupContent()
    }
}