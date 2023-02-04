package com.alife.anotherlife.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.core.navigation.routes.NavigationRoute
import com.alife.anotherlife.ui.test_nav.TestUserArgsContainerModel
import com.alife.anotherlife.ui.test_nav.builder.TestUserArgNavBuilder
import com.alife.anotherlife.ui.test_nav.UserIdNavArgModel
import com.alife.anotherlife.ui.test_nav.builder.TestUserNavBuilder

class MainNavigationGraph(private val startNavigationRoute: NavigationRoute) : NavigationGraph {

    @Composable
    override fun SetupNavigation(navHostController: NavHostController) {
        NavHost(
            navController = navHostController,
            startDestination = startNavigationRoute.routeTag
        ) {
            TestUserArgNavBuilder { argsContainer, backStack ->
                backStack.arguments?.getString(argsContainer.userIdNavArgModel.name)
            }.navigationRoute(this)

            TestUserNavBuilder{}.navigationRoute(this)

            TestNavRouteBuilder(
                TestUserArgsContainerModel(UserIdNavArgModel())
            ).navigationRoute(this) { containerModel, navBackStackEntry ->
                navBackStackEntry.arguments?.getString(containerModel.userIdNavArgModel.name)
                // Some Screen
            }

            TestDefaultNavigationRoute().navigationRoute(this) {
                // Some Screen
            }
        }
    }
}