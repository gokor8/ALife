package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

interface BaseHomeChildReducer {

    suspend fun onInit()

    suspend fun onTakeALife()
}