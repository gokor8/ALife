package com.alife.anotherlife.core.navigation.nav_navigator

import com.alife.anotherlife.core.navigation.nav_arg_container.ArgsContainer
import com.alife.anotherlife.core.navigation.routes.NavigationRoute

abstract class ArgsNavigator(navigationRoute: NavigationRoute) : BaseNavigator(navigationRoute) {

    protected abstract val argsContainer: ArgsContainer
}