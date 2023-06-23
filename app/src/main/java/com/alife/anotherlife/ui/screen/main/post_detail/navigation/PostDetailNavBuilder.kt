package com.alife.anotherlife.ui.screen.main.post_detail.navigation

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewArgsNavigationBuilder
import com.alife.anotherlife.core.ui.screen.Screen
import com.alife.anotherlife.ui.screen.main.post_detail.PostDetailScreen
import com.alife.anotherlife.ui.screen.main.post_detail.navigation.args.PostDetailArgsContainer

class PostDetailNavBuilder(
    navController: NavController
) : NewArgsNavigationBuilder<PostDetailArgsContainer>(
    navController,
    PostDetailNavRoute(),
    PostDetailArgsContainer()
) {

    override fun createScreen(
        navBackStackEntry: NavBackStackEntry,
        containerModel: PostDetailArgsContainer
    ): Screen {
        val username = navBackStackEntry.arguments?.getString(containerModel.username.name) ?: ""
        return PostDetailScreen(navController, username)
    }
}