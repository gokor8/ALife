package com.alife.anotherlife.core.navigation.nav_navigator

import androidx.annotation.CallSuper
import com.alife.anotherlife.core.navigation.routes.NavigationRoute

open class BaseNavigator(protected val navigationRoute: NavigationRoute) : Navigator {

    @CallSuper
    override fun toString(): String = navigationRoute.routeTag
}