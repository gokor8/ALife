package com.alife.anotherlife.ui.screen.main

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
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.HomeNavBarItem
import com.alife.anotherlife.ui.screen.main.navigation_bar.profile.ProfileNavBarItem
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.MapNavBarItem

class MainScreen : DefaultScreen() {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content(modifier: Modifier) {

        val navController = rememberNavController()
        val bottomBarItems = listOf(MapNavBarItem(), HomeNavBarItem(), ProfileNavBarItem())

        Scaffold(
            bottomBar = {
                NavigationBar(modifier = Modifier.clip(Shapes.large)) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
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
        ) { innerPadding ->
            com.alife.anotherlife.ui.screen.main.BottomBarNavGraph(innerPadding).SetupNavigation(navHostController = navController)
        }
    }
}