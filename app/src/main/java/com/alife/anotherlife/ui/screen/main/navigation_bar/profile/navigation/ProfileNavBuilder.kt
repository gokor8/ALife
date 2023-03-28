package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.ProfileScreen

class ProfileNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, ProfileNavigationRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry) = ProfileScreen()
}