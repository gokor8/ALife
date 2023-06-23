package com.alife.anotherlife.core.navigation

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.alife.anotherlife.core.navigation.nav_navigator.BaseNavigator
import com.alife.anotherlife.ui.screen.splash.navigation.SplashScreenNavRoute

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

    abstract class ForwardAndBackClear(
        defaultNavigator: BaseNavigator
    ) : NavigationWrapper(defaultNavigator) {

        override fun navigate(navController: NavController) {
            navController.navigate(
                route = defaultNavigator.toString(),
                builder = {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                }
            )
        }
    }

    abstract class ForwardNewGraphClearAll(
        defaultNavigator: BaseNavigator
    ) : NavigationWrapper(defaultNavigator) {

        override fun navigate(navController: NavController) {

            navController.navigate(route = SplashScreenNavRoute().routeTag) {
                // Установка флага popUpTo для очистки стека
                popUpTo(defaultNavigator.toString()) {
                    // Включительно с указанным назначением
                    inclusive = true
                }
            }
        }
    }

    abstract class ForwardSingleInclusive(
        defaultNavigator: BaseNavigator
    ) : NavigationWrapper(defaultNavigator) {

        override fun navigate(navController: NavController) {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(navController.graph.startDestinationId, inclusive = true)
                .setLaunchSingleTop(true)
                .build()

            navController.navigate(
                route = defaultNavigator.toString(),
                navOptions = navOptions
            )
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