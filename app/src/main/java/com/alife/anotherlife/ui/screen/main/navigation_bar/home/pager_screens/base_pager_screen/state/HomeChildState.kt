package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state

import androidx.paging.PagingData
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPlzCreatePostModel
import com.alife.core.mvi.MVI
import kotlinx.coroutines.flow.Flow

data class HomeChildState(
    // Set load state
    val profileList: List<UIPostModel> = listOf(UIPlzCreatePostModel()),
    val postsPagingData: Flow<PagingData<UIPostModel>>? = null
) : MVI.State