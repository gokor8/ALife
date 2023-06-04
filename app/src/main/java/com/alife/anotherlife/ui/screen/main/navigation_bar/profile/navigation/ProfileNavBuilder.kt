package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.main.BottomBarNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.ProfileScreen

class ProfileNavBuilder(
    innerPadding: PaddingValues,
    navController: NavController
) : BottomBarNavBuilder(innerPadding, navController, ProfileNavigationRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry) = ProfileScreen(innerPadding, navController)
}