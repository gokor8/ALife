package com.alife.anotherlife.core.navigation

import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_arg_container.ArgsContainer

sealed class NavigationWrapper(protected val defaultNavigator: ArgsContainer.Navigator) {

    abstract fun navigate(navController: NavController)


    class Navigate(defaultNavigator: ArgsContainer.Navigator) : NavigationWrapper(defaultNavigator) {

        override fun navigate(navController: NavController) {
            navController.navigate(defaultNavigator.toString())
        }
    }
}