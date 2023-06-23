package com.alife.anotherlife.ui.screen.main.navigation_bar.home.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.NavController
import com.alife.anotherlife.core.ui.screen.Screen

interface BaseHomePagerItem {

    @Composable
    fun screen(navController: NavController, isVisible: Boolean): Screen

    @Composable
    fun TabContent(selected: Boolean, onClick: () -> Unit)

    @Composable
    fun textWidth(): Dp
}