package com.alife.anotherlife.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.ui.example.test.navigation.TestNavBuilder
import com.alife.anotherlife.ui.example.test.navigation.TestNavRoute
import com.alife.anotherlife.ui.example.test.screen.TestScreen
import com.alife.anotherlife.ui.example.test.screen.TestViewModel
import com.alife.anotherlife.ui.screen.main.main_screen.navigation.MainScreenNavBuilder
import com.alife.anotherlife.ui.screen.registration.tutorial.navigation.TutorialNavBuilder
import javax.inject.Inject

class DevNavigationGraph @Inject constructor() : NavigationGraph {

    @Composable
    override fun SetupNavigation(navHostController: NavHostController) {
        NavHost(
            navController = navHostController,
            startDestination = TestNavRoute().routeTag
        ) {
            listOf(
                TestNavBuilder {
                    TestScreen(navHostController).SetupContent()
                },
                TutorialNavBuilder(navHostController),
                MainScreenNavBuilder(navHostController)
            ).forEach { it.navComposable(this) }
        }
    }
}