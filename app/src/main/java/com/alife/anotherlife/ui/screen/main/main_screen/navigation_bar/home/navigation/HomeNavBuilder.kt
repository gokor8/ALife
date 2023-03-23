package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.HomeScreen

class HomeNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, HomeNavigationRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry) = HomeScreen()
}