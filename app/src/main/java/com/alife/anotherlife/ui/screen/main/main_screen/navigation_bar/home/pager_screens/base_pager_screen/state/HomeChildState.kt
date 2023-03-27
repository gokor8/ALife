package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.state

import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.model.UICardModel
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.model.UILoadCardModel
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.model.UIPlzCreateAlifeCardModel
import com.alife.core.mvi.MVI

data class HomeChildState(
    val profileList: List<UICardModel> = listOf(UILoadCardModel())
) : MVI.State