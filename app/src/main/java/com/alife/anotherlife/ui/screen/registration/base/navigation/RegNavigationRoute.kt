package com.alife.anotherlife.ui.screen.registration.base.navigation

import com.alife.anotherlife.core.navigation.routes.NavigationRoute

abstract class RegNavigationRoute : NavigationRoute {

    final override val routeTag: String
        get() = "reg_$regRouteTag"


    protected abstract val regRouteTag: String
}