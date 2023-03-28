package com.alife.anotherlife.ui.screen.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.navigation.HomeNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.navigation.HomeNavigationRoute
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.navigation.MapNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.navigation.ProfileNavBuilder

class BottomBarNavGraph(private val innerPadding: PaddingValues) : NavigationGraph {

    @Composable
    override fun SetupNavigation(navHostController: NavHostController) {
        NavHost(
            navController = navHostController,
            startDestination = HomeNavigationRoute().routeTag
        ) {
            listOf(
                MapNavBuilder(navHostController),
                HomeNavBuilder(navHostController),
                ProfileNavBuilder(navHostController)
            ).forEach { it.navComposable(this) }
        }
    }
}