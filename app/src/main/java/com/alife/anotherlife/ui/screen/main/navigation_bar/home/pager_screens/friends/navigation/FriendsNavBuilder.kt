package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.friends.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.friends.FriendsScreen

class FriendsNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, FriendsNavRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry) = FriendsScreen(navController) {}
}