package com.alife.anotherlife.ui.screen.registration.name.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.registration.name.NameRegistrationScreen

class RegistrationNavBuilder(
    private val navController: NavController
) : NewDefaultNavBuilder(RegistrationNavRoute()) {

    @Composable
    override fun Content(navBackStackEntry: NavBackStackEntry) {
        NameRegistrationScreen(navController = navController).SetupContent()
    }
}