package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.list

import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.model.BaseHomePagerItem
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.model.HomePagerItem
import com.alife.domain.core.list.IndexWrapperList

class HomePagerIndexWrapperList(
    vararg homePagerItem: HomePagerItem
) : IndexWrapperList<HomePagerIndexWrapper, BaseHomePagerItem>(
    HomePagerToIndexWrapper(),
    *homePagerItem
)