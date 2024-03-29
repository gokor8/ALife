package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.media3.exoplayer.ExoPlayer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.DefaultPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPlzCreatePostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPostModel

class DefaultPostContainerUI(
    private val uiPostModel: DefaultPostModel
) : UIBasePostContainer {

    override fun itemKey() = uiPostModel.itemKey()

    @Composable
    fun Post(
        viewModel: AbstractHomeChildViewModel,
        modifier: Modifier
    ) {
        uiPostModel.Card(viewModel, modifier)
    }
}

class PlzCreatePostContainerUI : UIBasePostContainer {

    private val uiPostModel = UIPlzCreatePostModel()

    override fun itemKey() = uiPostModel.itemKey()

    @Composable
    fun Post(viewModel: AbstractHomeChildViewModel, modifier: Modifier) {
        uiPostModel.Card(viewModel, modifier)
    }
}