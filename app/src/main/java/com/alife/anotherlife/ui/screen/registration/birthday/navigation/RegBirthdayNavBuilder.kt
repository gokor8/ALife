package com.alife.anotherlife.ui.screen.registration.birthday.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.core.ui.screen.Screen
import com.alife.anotherlife.ui.screen.registration.birthday.BirthdayRegistrationScreen

class RegBirthdayNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, RegBirthdayNavRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry): Screen {
        return BirthdayRegistrationScreen(navController = navController)
    }
}