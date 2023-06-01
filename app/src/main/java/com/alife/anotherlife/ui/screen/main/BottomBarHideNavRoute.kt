package com.alife.anotherlife.ui.screen.main

import com.alife.anotherlife.core.navigation.routes.NavigationRoute

interface BottomBarHideNavRoute : NavigationRoute {

    override val routeTag: String
        get() = "${sageRouteTag()}_bottom_bar_hide"

    fun sageRouteTag(): String
}