package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model

class PageVerify(private val page: Int) {

    private val firstPageIndex = 1

    fun isPageFirst() = page == firstPageIndex
}