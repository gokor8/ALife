package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.FinishPictureScreen
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.FinishVideoScreen

class FinishPictureNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, FinishPictureNavRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry) = FinishPictureScreen(navController)
}