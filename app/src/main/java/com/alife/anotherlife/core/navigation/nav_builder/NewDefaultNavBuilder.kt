package com.alife.anotherlife.core.navigation.nav_builder

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alife.anotherlife.core.navigation.routes.NavigationRoute

abstract class NewDefaultNavBuilder(
    override val navigationRoute: NavigationRoute,
) : BaseNavigationBuilder() {

    @Composable
    protected abstract fun Content(navBackStackEntry: NavBackStackEntry)

    override fun navComposable(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable(
            route = navigationRoute.routeTag,
            content = { Content(it) }
        )
    }
}