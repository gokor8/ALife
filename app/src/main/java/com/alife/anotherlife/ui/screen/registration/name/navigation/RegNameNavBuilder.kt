package com.alife.anotherlife.ui.screen.registration.name.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.core.ui.screen.Screen
import com.alife.anotherlife.ui.screen.registration.name.NameRegistrationScreen

class RegNameNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, RegNameNavRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry): Screen {
        return NameRegistrationScreen(navController = navController)
    }
}