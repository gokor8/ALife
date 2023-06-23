package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state

import androidx.paging.PagingData
import com.alife.anotherlife.core.ui.state.lce.LCEContent
import com.alife.anotherlife.core.ui.state.lce.LCEModel
import com.alife.anotherlife.core.ui.state.lce.StateLCE
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPlzCreatePostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.UIPostLoaderModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.UIBasePostContainer
import kotlinx.coroutines.flow.Flow

data class HomeChildState(
    override val lceModel: LCEModel = LCEContent,
    val uiLoaderModel: UIPostLoaderModel = UIPostLoaderModel.EmptyModel,
    val profileList: List<UIPostModel> = listOf(UIPlzCreatePostModel()),
    val postsPagingData: Flow<PagingData<UIBasePostContainer>>? = null,
    val previousScrollPosition: Int = 0,
    val playingItemIndex: Int = -1,
    val isRefreshing: Boolean = false,
    val isHavePostToday: Boolean = false,
) : StateLCE, HomeStateEffect