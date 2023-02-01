package com.alife.anotherlife.core.navigation.argument

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alife.anotherlife.core.navigation.NavigationModel
import com.alife.anotherlife.core.navigation.argument.model.NavigationArgModel

abstract class ArgsNavigationModel : NavigationModel {

    override fun navigationRoute(
        navGraphBuilder: NavGraphBuilder,
        args: List<NavigationArgModel<*>>,
        content: @Composable (NavBackStackEntry) -> Unit
    ) {
        navGraphBuilder.composable(
            route = "$routeTag${args.joinToString { argModel -> argModel.toString() }}",
            arguments = args.map { argModel -> argModel.createNavArg() },
            content = content
        )
    }
}