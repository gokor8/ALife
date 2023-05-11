package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel

interface UICardModel {

    fun itemKey(): String

    @Composable
    fun Card(viewModel: AbstractHomeChildViewModel, modifier: Modifier)
}