package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar

import com.alife.anotherlife.core.navigation.routes.NavigationRoute

interface NavBarItemRoute : NavigationRoute {

    override val routeTag: String
        get() = "baton_bar_$navBarItemRouteTag"

    val navBarItemRouteTag: String
}