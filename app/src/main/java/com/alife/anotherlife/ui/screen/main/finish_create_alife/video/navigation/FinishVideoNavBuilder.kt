package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.FinishVideoScreen

class FinishVideoNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, FinishVideoNavRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry) = FinishVideoScreen(navController)
}