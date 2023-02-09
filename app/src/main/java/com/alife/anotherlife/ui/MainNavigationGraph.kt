package com.alife.anotherlife.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.core.navigation.nav_navigator.BaseNavigator
import com.alife.anotherlife.core.navigation.routes.NavigationRoute
import com.alife.anotherlife.ui.example.navigation.user.navigator.UserArgsNavigator
import com.alife.anotherlife.ui.example.navigation.user.builder.UserArgsNavBuilder
import com.alife.anotherlife.ui.example.navigation.user.builder.UserNavBuilder
import com.alife.anotherlife.ui.example.navigation.user.UserNavRoute
import com.alife.anotherlife.ui.screen.login.LoginScreen
import com.alife.anotherlife.ui.screen.login.navigation.LoginNavBuilder

class MainNavigationGraph(private val startNavigationRoute: NavigationRoute) : NavigationGraph {

    @Composable
    override fun SetupNavigation(navHostController: NavHostController) {
        NavHost(
            navController = navHostController,
            startDestination = startNavigationRoute.routeTag
        ) {
            LoginNavBuilder {
                LoginScreen().Content()
            }.navComposable(this)
        }
    }
}