package com.alife.anotherlife.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.ui.example.test.navigation.TestNavBuilder
import com.alife.anotherlife.ui.example.test.navigation.TestNavRoute
import com.alife.anotherlife.ui.example.test.screen.TestScreen
import com.alife.anotherlife.ui.screen.main.create_alife.navigation.CreateAlifeNavBuilder
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.navigation.FinishPictureNavBuilder
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.navigation.FinishVideoNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation.MainScreenNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.navigation.HomeNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.friends.navigation.FriendsNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.world.navigation.WorldNavBuilder
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
                MainScreenNavBuilder(navHostController),
                HomeNavBuilder(navHostController),
                FriendsNavBuilder(navHostController),
                WorldNavBuilder(navHostController),
                CreateAlifeNavBuilder(navHostController),
                FinishPictureNavBuilder(navHostController),
                FinishVideoNavBuilder(navHostController)
            ).forEach { it.navComposable(this) }
        }
    }
}