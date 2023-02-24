package com.alife.anotherlife.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.core.navigation.routes.NavigationRoute
import com.alife.anotherlife.ui.screen.login.navigation.LoginNavBuilder
import com.alife.anotherlife.ui.screen.registration.name.navigation.RegistrationNavBuilder

class MainNavigationGraph(private val startNavigationRoute: NavigationRoute) : NavigationGraph {

    @Composable
    override fun SetupNavigation(navHostController: NavHostController) {
        NavHost(
            navController = navHostController,
            startDestination = startNavigationRoute.routeTag
        ) {
            listOf(
                LoginNavBuilder(navHostController),
                RegistrationNavBuilder(navHostController)
            ).forEach { it.navComposable(this) }
        }
    }
}