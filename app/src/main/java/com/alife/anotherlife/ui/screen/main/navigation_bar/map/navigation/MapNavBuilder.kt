package com.alife.anotherlife.ui.screen.main.navigation_bar.map.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.padding.BottomPaddingModel
import com.alife.anotherlife.ui.screen.main.BottomBarNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.MapScreen

class MapNavBuilder(
    innerPadding: PaddingValues,
    navController: NavController
) : BottomBarNavBuilder(innerPadding, navController, MapNavigationRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry) =
        MapScreen(BottomPaddingModel(innerPadding), navController)
}