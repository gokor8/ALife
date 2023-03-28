package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.model

import androidx.compose.runtime.Composable

interface BaseHomePagerItem {

    @Composable
    fun Screen()

    @Composable
    fun TabContent(selected: Boolean, onClick: () -> Unit)
}