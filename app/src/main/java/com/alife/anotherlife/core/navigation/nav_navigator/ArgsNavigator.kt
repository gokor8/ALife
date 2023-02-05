package com.alife.anotherlife.core.navigation.nav_navigator

import com.alife.anotherlife.core.navigation.nav_builder.args.ArgsContainerModel
import com.alife.anotherlife.core.navigation.routes.NavigationRoute

abstract class ArgsNavigator(
    route: NavigationRoute
) : BaseNavigator(route) {

    abstract val containerModel: ArgsContainerModel

}