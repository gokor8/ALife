package com.alife.anotherlife.core.navigation.nav_builder

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alife.anotherlife.core.navigation.routes.NavigationRoute

abstract class DefaultNavigationBuilder(
    override val navigationRoute: NavigationRoute,
) : BaseNavigationBuilder() {

    protected abstract val content: @Composable (NavBackStackEntry) -> Unit

    override fun navigationRoute(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable(
            route = navigationRoute.routeTag,
            content = content
        )
    }
}