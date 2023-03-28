package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.world.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.world.WorldScreen

class WorldNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, WorldNavRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry) = WorldScreen(navController)
}