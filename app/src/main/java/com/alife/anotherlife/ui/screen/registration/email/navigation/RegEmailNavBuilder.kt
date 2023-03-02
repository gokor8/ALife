package com.alife.anotherlife.ui.screen.registration.email.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.registration.email.EmailRegistrationScreen
import com.alife.anotherlife.ui.screen.registration.name.NameRegistrationScreen
import com.alife.anotherlife.ui.screen.registration.name.navigation.RegNameNavRoute

class RegEmailNavBuilder(
    private val navController: NavController
) : NewDefaultNavBuilder(RegEmailNavRoute()) {

    @Composable
    override fun Content(navBackStackEntry: NavBackStackEntry) {
        EmailRegistrationScreen(navController = navController).SetupContent()
    }
}