package com.alife.anotherlife.core.navigation.nav_builder

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alife.anotherlife.core.navigation.nav_builder.args.ArgsContainerModel
import com.alife.anotherlife.core.navigation.routes.NavigationRoute

abstract class ArgsNavigationRouteBuilder<ACM : ArgsContainerModel>(
    override val navigationRoute: NavigationRoute,
    private val containerModel: ACM,
) : NavigationRouteBuilder() {

    protected abstract val content: @Composable (ACM, NavBackStackEntry) -> Unit

    override fun navigationRoute(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable(
            route = "${navigationRoute.routeTag}$containerModel",
            arguments = containerModel.navArgList().map { arg -> arg.createNavArg() },
            content = { navBackStackEntry -> content(containerModel, navBackStackEntry) }
        )
    }
}