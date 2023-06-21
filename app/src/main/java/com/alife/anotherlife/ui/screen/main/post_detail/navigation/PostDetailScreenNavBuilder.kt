package com.alife.anotherlife.ui.screen.main.post_detail.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.main.MainScreen
import com.alife.anotherlife.ui.screen.main.post_detail.PostDetailScreen

class PostDetailScreenNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, PostDetailScreenNavRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry) = PostDetailScreen(navController)
}