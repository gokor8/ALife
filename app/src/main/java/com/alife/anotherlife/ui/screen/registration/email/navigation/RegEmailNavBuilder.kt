package com.alife.anotherlife.ui.screen.registration.email.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.core.ui.screen.Screen
import com.alife.anotherlife.ui.screen.registration.email.EmailRegistrationScreen
import com.alife.anotherlife.ui.screen.registration.name.NameRegistrationScreen
import com.alife.anotherlife.ui.screen.registration.name.navigation.RegNameNavRoute

class RegEmailNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, RegEmailNavRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry): Screen {
        return EmailRegistrationScreen(navController = navController)
    }
}