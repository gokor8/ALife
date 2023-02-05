package com.alife.anotherlife.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.core.navigation.routes.NavigationRoute
import com.alife.anotherlife.ui.test_nav.TestUserArgsContainer
import com.alife.anotherlife.ui.test_nav.TestUserArgsNavigator
import com.alife.anotherlife.ui.test_nav.builder.TestUserArgsNavBuilder
import com.alife.anotherlife.ui.test_nav.builder.TestUserNavBuilder

class MainNavigationGraph(private val startNavigationRoute: NavigationRoute) : NavigationGraph {

    @Composable
    override fun SetupNavigation(navHostController: NavHostController) {
        NavHost(
            navController = navHostController,
            startDestination = startNavigationRoute.routeTag
        ) {
            TestUserArgsNavBuilder { argsContainer, backStack ->
                backStack.arguments?.getString(argsContainer.userIdNavArgModel.name)
            }.navigationRoute(this)

            TestUserNavBuilder{}.navigationRoute(this)

            NavigationWrapper.Navigate(
                TestUserArgsContainer.TestUserArgsNavigator("1")
            ).navigate(navHostController)
            navHostController.navigate(TestUserArgsContainer.TestUserArgsNavigator("1").navigationRoute())
        }
    }
}