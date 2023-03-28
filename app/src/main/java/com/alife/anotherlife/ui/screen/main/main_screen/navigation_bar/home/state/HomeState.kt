package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.state

import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.list.HomePagerIndexWrapperList
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.model.FriendsPagerItem
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.model.WorldPagerItem
import com.alife.core.mvi.MVI
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
data class HomeState(
    val pagerScreens: HomePagerIndexWrapperList = HomePagerIndexWrapperList(
        FriendsPagerItem(),
        WorldPagerItem()
    ),
    val pagerState: PagerState = PagerState(currentPage = 0)
) : MVI.State