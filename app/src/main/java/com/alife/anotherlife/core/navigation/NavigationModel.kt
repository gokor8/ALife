package com.alife.anotherlife.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import com.alife.anotherlife.core.navigation.argument.model.NavigationArgModel

interface NavigationModel {

    val routeTag: String

    fun navigationRoute(
        navGraphBuilder: NavGraphBuilder,
        args: List<NavigationArgModel<*>>,
        content: @Composable (NavBackStackEntry) -> Unit
    )
}