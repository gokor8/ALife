package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.paging

interface PagingLoadCallback {

    suspend fun onLoad(isHavePostToday: Boolean)
}