package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.BaseHomeChildViewModel

interface UICardModel {

    fun itemKey(): String

    @Composable
    fun Card(viewModel: BaseHomeChildViewModel, modifier: Modifier)
}