package com.alife.anotherlife.ui.screen.main

import com.alife.anotherlife.core.navigation.routes.NavigationRoute

interface BottomBarHideNavRoute : NavigationRoute {

    override val routeTag: String
        get() = "${sageRouteTag()}_${BottomBarHideTag().routeTag}"

    fun sageRouteTag(): String
}

class BottomBarHideTag {
    val routeTag: String = "bottom_bar_hide"
}