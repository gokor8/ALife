package com.alife.anotherlife.core.navigation.nav_builder

import androidx.navigation.NavGraphBuilder
import com.alife.anotherlife.core.navigation.routes.NavigationRoute

abstract class BaseNavigationBuilder {

    protected abstract val navigationRoute: NavigationRoute


    fun routeTag() = navigationRoute.routeTag

    abstract fun navComposable(navGraphBuilder: NavGraphBuilder)
}