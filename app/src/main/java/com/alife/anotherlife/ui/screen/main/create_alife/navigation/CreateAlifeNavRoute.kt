package com.alife.anotherlife.ui.screen.main.create_alife.navigation

import com.alife.anotherlife.core.navigation.routes.NavigationRoute
import com.alife.anotherlife.ui.screen.main.BottomBarHideNavRoute

class CreateAlifeNavRoute : NavigationRoute {
    override val routeTag: String
        get() = "create_alife" + BottomBarHideNavRoute().routeTag
}