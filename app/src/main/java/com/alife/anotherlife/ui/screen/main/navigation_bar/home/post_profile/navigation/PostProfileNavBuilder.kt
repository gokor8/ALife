package com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.navigation

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewArgsNavigationBuilder
import com.alife.anotherlife.core.ui.screen.Screen
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.PostProfileScreen
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.navigation.args.PostProfileArgsContainer

class PostProfileNavBuilder(navController: NavController) :
    NewArgsNavigationBuilder<PostProfileArgsContainer>(
        navController,
        PostProfileNavRoute(),
        PostProfileArgsContainer()
    ) {
    override fun createScreen(
        navBackStackEntry: NavBackStackEntry,
        containerModel: PostProfileArgsContainer
    ): Screen {
        val username = navBackStackEntry.arguments?.getString(containerModel.username.name) ?: ""
        return PostProfileScreen(navController, username)
    }
}