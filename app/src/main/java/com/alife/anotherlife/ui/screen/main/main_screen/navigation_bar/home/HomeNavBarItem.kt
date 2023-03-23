package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home

import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.NavigationBarItemComposable
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.navigation.HomeNavigationRoute

class HomeNavBarItem : NavigationBarItemComposable.Abstract(
    R.drawable.ic_bottom_bar_home,
    R.string.bottom_bar_home,
    HomeNavigationRoute()
)