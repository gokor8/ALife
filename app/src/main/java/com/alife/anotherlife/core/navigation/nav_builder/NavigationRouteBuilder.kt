package com.alife.anotherlife.core.navigation.nav_builder

import androidx.navigation.NavGraphBuilder
import com.alife.anotherlife.core.navigation.routes.NavigationRoute

abstract class NavigationRouteBuilder {

    protected abstract val navigationRoute: NavigationRoute

    abstract fun navigationRoute(navGraphBuilder: NavGraphBuilder)
}