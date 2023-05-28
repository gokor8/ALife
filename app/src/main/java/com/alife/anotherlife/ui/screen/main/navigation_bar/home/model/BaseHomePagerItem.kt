package com.alife.anotherlife.ui.screen.main.navigation_bar.home.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.alife.anotherlife.core.ui.screen.Screen

interface BaseHomePagerItem {

    @Composable
    fun screen(navController: NavController, pagingVisibility: (Boolean) -> Unit): Screen

    @Composable
    fun TabContent(selected: Boolean, onClick: () -> Unit)

    @Composable
    fun textWidth(): Dp
}