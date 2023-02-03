package com.alife.anotherlife.core.navigation.nav_factory

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alife.anotherlife.core.navigation.args.ArgsContainerModel
import com.alife.anotherlife.core.navigation.nav_factory.base.NavigationFactory

abstract class ArgsNavigationFactory<ACM : ArgsContainerModel>(private val containerModel: ACM) :
    NavigationFactory {

    fun navigationRoute(
        navGraphBuilder: NavGraphBuilder,
        content: @Composable (ACM, NavBackStackEntry) -> Unit
    ) {
        navGraphBuilder.composable(
            route = "$routeTag$containerModel",
            arguments = containerModel.navArgList().map { arg -> arg.createNavArg() },
            content = { navBackStackEntry -> content(containerModel, navBackStackEntry) }
        )
//        navGraphBuilder.composable(
//            route = "$routeTag${args.joinToString { argModel -> argModel.toString() }}",
//            arguments = args.map { argModel -> argModel.createNavArg() },
//            content = content
//        )
    }
}