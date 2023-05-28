package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.navigation

import com.alife.anotherlife.core.navigation.routes.NavigationRoute
import com.alife.anotherlife.ui.screen.main.BottomBarHideNavRoute

class FinishVideoNavRoute : NavigationRoute {
    override val routeTag: String = "finish_video" + BottomBarHideNavRoute().routeTag
}