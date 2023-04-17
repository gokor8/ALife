package com.alife.anotherlife.ui.screen.main.navigation_bar.home.model

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.screen.Screen
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.world.WorldScreen

class WorldPagerItem : HomePagerItem(R.string.home_pager_world) {

    @Composable
    override fun screen(navController: NavController, pagingVisibility: (Boolean) -> Unit) =
        WorldScreen(navController, pagingVisibility)
}