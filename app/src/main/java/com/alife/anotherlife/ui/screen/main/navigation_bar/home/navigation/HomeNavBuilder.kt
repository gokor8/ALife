package com.alife.anotherlife.ui.screen.main.navigation_bar.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.main.BottomBarNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.HomeScreen

class HomeNavBuilder(
    innerPadding: PaddingValues,
    navController: NavController
) : BottomBarNavBuilder(innerPadding, navController, HomeNavigationRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry) = HomeScreen(innerPadding, navController)
}