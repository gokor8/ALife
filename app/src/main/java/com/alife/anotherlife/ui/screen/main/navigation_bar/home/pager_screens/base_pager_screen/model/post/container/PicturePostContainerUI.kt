package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel
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
    override fun clear(viewModel: AbstractHomeChildViewModel, modifier: Modifier): UIPostModel {
        return UIPhotosPostModel(username, timestamp, avatar, frontAlife, backAlife)
    }

    @Composable
    override fun blur(viewModel: AbstractHomeChildViewModel, modifier: Modifier): UIPostModel {
        return BlurUIPhotosPostModel(username, timestamp, avatar, frontAlife, backAlife)
    }
}