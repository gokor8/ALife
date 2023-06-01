package com.alife.anotherlife.ui.screen.main.navigation_bar.home.model

interface TabsVisibilityContract {

    suspend fun onTabsInvisible()

    suspend fun onTabsVisible()

    suspend fun onTabVisibility(isVisible: Boolean)
}