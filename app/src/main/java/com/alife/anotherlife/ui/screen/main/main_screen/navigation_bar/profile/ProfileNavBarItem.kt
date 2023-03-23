package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.profile

import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.NavigationBarItemComposable
import com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.profile.navigation.ProfileNavigationRoute

class ProfileNavBarItem : NavigationBarItemComposable.Abstract(
    R.drawable.ic_bottom_bar_profile,
    R.string.bottom_bar_profile,
    ProfileNavigationRoute()
)