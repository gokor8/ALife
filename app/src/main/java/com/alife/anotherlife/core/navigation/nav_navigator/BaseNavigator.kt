package com.alife.anotherlife.core.navigation.nav_navigator

import androidx.annotation.CallSuper
import com.alife.anotherlife.core.navigation.routes.NavigationRoute

abstract class BaseNavigator(private val route: NavigationRoute) {

    @CallSuper
    override fun toString(): String = route.routeTag
}