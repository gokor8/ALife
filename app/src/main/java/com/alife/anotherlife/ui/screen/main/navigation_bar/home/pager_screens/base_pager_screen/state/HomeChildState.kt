package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state

import androidx.paging.PagingData
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPlzCreatePostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.UIPostLoaderModel
import kotlinx.coroutines.flow.Flow

data class HomeChildState(
    // Set load state
    override val lceModel: LCEModel = LCEContent,
    val uiLoaderModel: UIPostLoaderModel = UIPostLoaderModel.EmptyModel(),
    val profileList: List<UIPostModel> = listOf(UIPlzCreatePostModel()),
    val postsPagingData: Flow<PagingData<UIPostModel>>? = null
) : StateLCE, HomeStateEffect