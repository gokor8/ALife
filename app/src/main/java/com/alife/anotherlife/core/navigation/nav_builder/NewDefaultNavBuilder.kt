package com.alife.anotherlife.core.navigation.nav_builder

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alife.anotherlife.core.navigation.routes.NavigationRoute
import com.alife.anotherlife.core.ui.screen.Screen

abstract class NewDefaultNavBuilder(
    override val navigationRoute: NavigationRoute,
) : BaseNavigationBuilder() {

    @Composable
    protected abstract fun content(navBackStackEntry: NavBackStackEntry): Screen

    override fun navComposable(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable(
            route = navigationRoute.routeTag,
            content = { content(it).SetupContent() }
        )
    }
}