package com.alife.anotherlife.core.navigation.nav_builder

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alife.anotherlife.core.navigation.nav_arg_container.ArgsContainer
import com.alife.anotherlife.core.navigation.routes.NavigationRoute
import com.alife.anotherlife.core.ui.screen.Screen

abstract class ArgsNavigationBuilder<ACM : ArgsContainer>(
    override val navigationRoute: NavigationRoute,
    private val containerModel: ACM,
) : BaseNavigationBuilder() {

    protected abstract val content: @Composable (ACM, NavBackStackEntry) -> Unit

    override fun navComposable(navGraphBuilder: NavGraphBuilder) {
        val route = "${navigationRoute.routeTag}${
            containerModel.argsList().joinToString("") { it.toString() }
        }"

        Log.d("Route", route)
        navGraphBuilder.composable(
            route = route,
            arguments = containerModel.argsList().map { arg -> arg.createNavArg() },
            content = { navBackStackEntry -> content(containerModel, navBackStackEntry) }
        )
    }
}

abstract class NewArgsNavigationBuilder<ACM : ArgsContainer>(
    protected val navController: NavController,
    override val navigationRoute: NavigationRoute,
    private val containerModel: ACM,
) : BaseNavigationBuilder() {

    override fun navComposable(navGraphBuilder: NavGraphBuilder) {
        val route = "${navigationRoute.routeTag}${
            containerModel.argsList().joinToString("") { it.toString() }
        }"

        Log.d("Route", route)
        navGraphBuilder.composable(
            route = route,
            arguments = containerModel.argsList().map { arg -> arg.createNavArg() },
            content = { navBackStackEntry ->
                createScreen(
                    navBackStackEntry,
                    containerModel
                ).SetupContent()
            }
        )
    }

    abstract fun createScreen(navBackStackEntry: NavBackStackEntry, containerModel: ACM): Screen
}