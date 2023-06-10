package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.media3.exoplayer.ExoPlayer
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.AbstractUIPhotosPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.BlurUIPhotosPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPhotosPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPostModel

class PicturePostContainerUI(
    override val username: String,
    override val timestamp: String,
    override val avatar: String? = null,
    private val frontAlife: String,
    private val backAlife: String,
) : UIBasePostContainer.Abstract() {

    @Composable
    fun Post(
        viewModel: AbstractHomeChildViewModel,
        modifier: Modifier
    ) {
        if (viewModel.getUIState().isHavePostToday) {
            clear(viewModel = viewModel, modifier = modifier)
        } else {
            blur(viewModel = viewModel, modifier = modifier)
        }.Card(viewModel, modifier)
    }

    @Composable
    override fun clear(viewModel: AbstractHomeChildViewModel, modifier: Modifier): AbstractUIPhotosPostModel {
        return UIPhotosPostModel(username, timestamp, avatar, frontAlife, backAlife)
    }

    @Composable
    override fun blur(viewModel: AbstractHomeChildViewModel, modifier: Modifier): AbstractUIPhotosPostModel {
        return BlurUIPhotosPostModel(username, timestamp, avatar, frontAlife, backAlife)
    }
}