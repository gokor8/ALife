package com.alife.anotherlife.ui.screen.main.navigation_bar.map

import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.main.navigation_bar.NavigationBarItemComposable
import com.alife.anotherlife.ui.screen.main.navigation_bar.map.navigation.MapNavigationRoute

class MapNavBarItem : NavigationBarItemComposable.Abstract(
    R.drawable.ic_bottom_bar_map,
    R.string.bottom_bar_map,
    MapNavigationRoute()
)