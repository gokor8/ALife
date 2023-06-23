package com.alife.anotherlife.ui.screen.registration.tutorial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.alife.anotherlife.core.navigation.nav_builder.NewDefaultNavBuilder
import com.alife.anotherlife.core.ui.screen.Screen
import com.alife.anotherlife.ui.screen.registration.tutorial.TutorialScreen

class TutorialNavBuilder(
    navController: NavController
) : NewDefaultNavBuilder(navController, TutorialNavRoute()) {

    @Composable
    override fun content(navBackStackEntry: NavBackStackEntry): Screen {
        return TutorialScreen(navController)
    }
}