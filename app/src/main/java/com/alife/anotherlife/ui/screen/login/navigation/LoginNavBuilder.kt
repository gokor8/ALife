package com.alife.anotherlife.ui.screen.login.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.DefaultNavigationBuilder
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.login.LoginScreen

class LoginNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, LoginNavRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry) = LoginScreen(navController)
}