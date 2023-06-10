package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.world

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.NavController
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.BaseHomeChildScreen
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.friends.FriendsViewModel

class WorldScreen(
    navController: NavController,
    isVisible: Boolean
) : BaseHomeChildScreen(navController, isVisible) {

    @Composable
    override fun setupViewModel(): WorldViewModel = hiltViewModel()
}