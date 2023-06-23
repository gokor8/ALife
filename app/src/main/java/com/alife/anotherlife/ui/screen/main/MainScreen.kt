package com.alife.anotherlife.ui.screen.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alife.anotherlife.core.ui.screen.DefaultScreen
import com.alife.anotherlife.theme.Shapes
import com.alife.anotherlife.theme.TopShapes
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.HomeNavBarItem
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.ProfileNavBarItem
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.MapNavBarItem

class MainScreen : DefaultScreen() {

    @Composable
    override fun Content(modifier: Modifier) {

        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: ""

        val bottomBarItems = listOf(MapNavBarItem(), HomeNavBarItem(), ProfileNavBarItem())

        Scaffold(
            bottomBar = {
                if (!currentRoute.contains(BottomBarHideTag().routeTag)) {
                    NavigationBar(modifier = Modifier.clip(TopShapes.large)) {
                        val currentDestination = navBackStackEntry?.destination
                        bottomBarItems.forEach { item ->
                            item.Content(
                                rowScope = this,
                                navRepeat = currentDestination?.hierarchy ?: sequenceOf(),
                                navController = navController
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            BottomBarNavGraph(
                PaddingValues(bottom = innerPadding.calculateBottomPadding())
            ).SetupNavigation(navHostController = navController)
        }
    }
}