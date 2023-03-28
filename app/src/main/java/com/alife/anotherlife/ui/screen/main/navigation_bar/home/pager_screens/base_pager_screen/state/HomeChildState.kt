package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state

import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UICardModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPlzCreateAlifeCardModel
import com.alife.core.mvi.MVI

data class HomeChildState(
    // Set load state
    val profileList: List<UICardModel> = listOf(UIPlzCreateAlifeCardModel())
) : MVI.State