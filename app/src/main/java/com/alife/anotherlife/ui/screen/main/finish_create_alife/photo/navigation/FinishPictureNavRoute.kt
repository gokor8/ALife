package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.navigation

import com.alife.anotherlife.core.navigation.routes.NavigationRoute
import com.alife.anotherlife.ui.screen.main.BottomBarHideNavRoute

class FinishPictureNavRoute : NavigationRoute {
    override val routeTag: String = "finish_picture" + BottomBarHideNavRoute().routeTag
}