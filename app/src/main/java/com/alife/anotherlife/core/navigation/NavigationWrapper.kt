package com.alife.anotherlife.core.navigation

import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_navigator.BaseNavigator

sealed class NavigationWrapper(protected val defaultNavigator: BaseNavigator) {

    abstract fun navigate(navController: NavController)


    class Navigate(defaultNavigator: BaseNavigator) : NavigationWrapper(defaultNavigator) {

        override fun navigate(navController: NavController) {
            navController.navigate(defaultNavigator.toString())
        }
    }
}