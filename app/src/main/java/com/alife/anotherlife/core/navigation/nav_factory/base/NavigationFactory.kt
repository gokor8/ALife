package com.alife.anotherlife.core.navigation.nav_factory.base

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder

interface NavigationFactory {

    val routeTag: String

//    fun navigationRoute(
//        navGraphBuilder: NavGraphBuilder,
//        content: @Composable (NavBackStackEntry) -> Unit
//    )
}