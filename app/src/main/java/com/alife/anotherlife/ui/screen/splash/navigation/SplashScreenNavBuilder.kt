package com.alife.anotherlife.ui.screen.splash.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.splash.SplashScreen

class SplashScreenNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, SplashScreenNavRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry) = SplashScreen(navController)
}