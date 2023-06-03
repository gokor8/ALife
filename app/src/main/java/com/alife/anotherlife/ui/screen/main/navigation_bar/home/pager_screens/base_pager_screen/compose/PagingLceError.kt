package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container.UIBasePostContainer

interface PagingLceError {

    @Composable
    fun LCEContent(modifier: Modifier, lazyPosts: LazyPagingItems<UIBasePostContainer>?)
}