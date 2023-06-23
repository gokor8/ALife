package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.media3.exoplayer.ExoPlayer
import androidx.paging.compose.LazyPagingItems
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.UIBasePostContainer

interface PagingLceError {

    @Composable
    fun LCEContent(
        lazyPosts: LazyPagingItems<UIBasePostContainer>?,
        modifier: Modifier
    )
}