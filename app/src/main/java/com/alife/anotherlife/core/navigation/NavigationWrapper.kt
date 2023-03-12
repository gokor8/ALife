package com.alife.anotherlife.core.navigation

import android.util.Log
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_navigator.BaseNavigator

sealed class NavigationWrapper(protected val defaultNavigator: BaseNavigator) {

    abstract fun navigate(navController: NavController)


    abstract class Forward(defaultNavigator: BaseNavigator) : NavigationWrapper(defaultNavigator) {

        override fun navigate(navController: NavController) {
            Log.d("Nav Route", defaultNavigator.toString())
            navController.navigate(defaultNavigator.toString())
        }
    }

    abstract class Back(defaultNavigator: BaseNavigator) : NavigationWrapper(defaultNavigator) {

        override fun navigate(navController: NavController) {
            Log.d("Nav Route", defaultNavigator.toString())
            navController.popBackStack(defaultNavigator.toString(), false, saveState = false)
        }
    }
}