package com.alife.anotherlife.ui.screen.registration.username.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.core.ui.screen.Screen
import com.alife.anotherlife.ui.screen.registration.username.UsernameRegistrationScreen

class UsernameRegNavBuilder(
    private val navController: NavController
) : NewDefaultNavBuilder(UsernameRegNavRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry): Screen {
        return UsernameRegistrationScreen(navController = navController)
    }
}