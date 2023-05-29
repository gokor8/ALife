package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state

import androidx.paging.PagingData
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPlzCreateAlifePostModel
import com.alife.core.mvi.MVI
import java.util.concurrent.Flow

data class HomeChildState(
    // Set load state
    val profileList: List<UIPostModel> = listOf(UIPlzCreateAlifePostModel()),
    val postsPagingData: Flow<PagingData<>>
) : MVI.State