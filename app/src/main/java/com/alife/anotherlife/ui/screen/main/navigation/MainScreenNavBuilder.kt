package com.alife.anotherlife.ui.screen.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.main.MainScreen

class MainScreenNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, MainScreenNavRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry) = MainScreen()
}