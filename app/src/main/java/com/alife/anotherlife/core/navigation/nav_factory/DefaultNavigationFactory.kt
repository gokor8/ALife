package com.alife.anotherlife.core.navigation.nav_factory

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alife.anotherlife.core.navigation.nav_factory.base.NavigationFactory

abstract class DefaultNavigationFactory : NavigationFactory {

    fun navigationRoute(
        navGraphBuilder: NavGraphBuilder,
        content: @Composable (NavBackStackEntry) -> Unit
    ) {
        navGraphBuilder.composable(
            route = routeTag,
            content = content
        )
    }
}