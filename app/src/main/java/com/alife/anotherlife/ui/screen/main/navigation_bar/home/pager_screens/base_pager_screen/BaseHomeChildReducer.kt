package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen

import kotlinx.coroutines.CoroutineScope

interface BaseHomeChildReducer {

    suspend fun onInit(viewModelScoped: CoroutineScope)

    suspend fun onTakeALife()
}