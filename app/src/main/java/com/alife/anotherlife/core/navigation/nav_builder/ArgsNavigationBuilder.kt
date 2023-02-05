package com.alife.anotherlife.core.navigation.nav_builder

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alife.anotherlife.core.navigation.nav_arg_container.ArgsContainer
import com.alife.anotherlife.core.navigation.routes.NavigationRoute

abstract class ArgsNavigationBuilder<ACM : ArgsContainer.Builder>(
    override val navigationRoute: NavigationRoute,
    private val containerModel: ACM,
) : BaseNavigationBuilder() {

    protected abstract val content: @Composable (ACM, NavBackStackEntry) -> Unit

    override fun navigationRoute(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable(
            route = "${navigationRoute.routeTag}$containerModel",
            arguments = containerModel.navArgList(),
            content = { navBackStackEntry -> content(containerModel, navBackStackEntry) }
        )
    }
}