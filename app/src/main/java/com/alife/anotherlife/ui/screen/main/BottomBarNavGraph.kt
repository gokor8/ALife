package com.alife.anotherlife.ui.screen.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alife.anotherlife.core.navigation.NavigationGraph
import com.alife.anotherlife.ui.screen.main.create_alife.navigation.CreateAlifeNavBuilder
import com.alife.anotherlife.ui.screen.main.finish_create_alife.photo.navigation.FinishPictureNavBuilder
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.navigation.FinishVideoNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.navigation.HomeNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.navigation.HomeNavigationRoute
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.friends.navigation.FriendsNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.world.navigation.WorldNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.post_profile.navigation.PostProfileNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.navigation.MapNavBuilder
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.navigation.ProfileNavBuilder

class BottomBarNavGraph(private val innerPadding: PaddingValues) : NavigationGraph {

    @Composable
    override fun SetupNavigation(navHostController: NavHostController) {
        NavHost(
            navController = navHostController,
            startDestination = HomeNavigationRoute().routeTag
        ) {
            listOf(
                MapNavBuilder(innerPadding, navHostController),
                HomeNavBuilder(innerPadding, navHostController),
                ProfileNavBuilder(innerPadding, navHostController),
                CreateAlifeNavBuilder(navHostController),
                FinishPictureNavBuilder(navHostController),
                FinishVideoNavBuilder(navHostController),
                PostProfileNavBuilder(navHostController)
            ).forEach { it.navComposable(this) }
        }
    }
}