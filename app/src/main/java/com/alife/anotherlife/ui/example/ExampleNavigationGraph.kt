package com.alife.anotherlife.ui.example

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.core.navigation.NavigationWrapper
import com.alife.anotherlife.core.navigation.nav_navigator.BaseNavigator
import com.alife.anotherlife.ui.example.navigation.start.StartNavBuilder
import com.alife.anotherlife.ui.example.navigation.start.StartNavRoute
import com.alife.anotherlife.ui.example.navigation.user.UserNavRoute
import com.alife.anotherlife.ui.example.navigation.user.builder.UserArgsNavBuilder
import com.alife.anotherlife.ui.example.navigation.user.builder.UserNavBuilder
import com.alife.anotherlife.ui.example.navigation.user.navigator.UserArgsNavigator
import com.alife.anotherlife.ui.example.screens.StartScreen
import com.alife.anotherlife.ui.example.screens.UserScreen

class ExampleNavigationGraph : NavigationGraph {

    @Composable
    override fun SetupNavigation(navHostController: NavHostController) {
        NavHost(
            navController = navHostController,
            startDestination = StartNavRoute().routeTag
        ) {
            StartNavBuilder {
                StartScreen(navController = navHostController)
            }

            UserArgsNavBuilder { argsContainer, backStack ->
                val id = backStack.arguments?.getString(argsContainer.userIdNavArg.name)
                UserScreen(userId = id)
            }.navComposable(this)

//            UserNavBuilder{
//
//            }.navComposable(this)
//
//            NavigationWrapper.Navigate(UserArgsNavigator("1")).navigate(navHostController)
//            NavigationWrapper.Navigate(BaseNavigator(UserNavRoute())).navigate(navHostController)
        }
    }
}