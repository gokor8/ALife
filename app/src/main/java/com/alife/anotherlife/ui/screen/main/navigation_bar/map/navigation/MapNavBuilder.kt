package com.alife.anotherlife.ui.screen.main.navigation_bar.map.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.MapScreen

class MapNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, MapNavigationRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry) = MapScreen()
}