package com.alife.anotherlife.core.navigation

import android.util.Log
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_navigator.BaseNavigator

interface BaseNavigationWrapper {
    fun navigate(navController: NavController)
}

sealed class NavigationWrapper(protected val defaultNavigator: BaseNavigator) : BaseNavigationWrapper {

    // TODO fix it
    abstract class Replace(defaultNavigator: BaseNavigator) : NavigationWrapper(defaultNavigator) {

        override fun navigate(navController: NavController) {
            // Log.d("Nav Route", defaultNavigator.toString())
            // navController.navigate(defaultNavigator.toString())
        }
    }

    abstract class Forward(defaultNavigator: BaseNavigator) : NavigationWrapper(defaultNavigator) {

        override fun navigate(navController: NavController) {
            Log.d("Nav Route", defaultNavigator.toString())
            navController.navigate(defaultNavigator.toString())
        }
    }

    abstract class BackTo(defaultNavigator: BaseNavigator) : NavigationWrapper(defaultNavigator) {

        override fun navigate(navController: NavController) {
            Log.d("Nav Route", defaultNavigator.toString())
            navController.popBackStack(defaultNavigator.toString(), false, saveState = false)
        }
    }

    abstract class Back : BaseNavigationWrapper {

        override fun navigate(navController: NavController) {
            Log.d("Nav Route", "Default back")
            navController.popBackStack()
        }
    }
}