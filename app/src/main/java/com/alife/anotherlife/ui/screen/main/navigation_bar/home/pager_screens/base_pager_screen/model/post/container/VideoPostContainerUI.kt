package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIPostModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIVideoPostModel

class VideoPostContainerUI(
    override val username: String,
    override val timestamp: String,
    override val avatar: String? = null,
    private val video: String
) : UIBasePostContainer.Abstract() {

    @Composable
    override fun clear(viewModel: AbstractHomeChildViewModel, modifier: Modifier): UIPostModel {
        return UIVideoPostModel(username, timestamp, avatar, video)
    }

    @Composable
    override fun blur(viewModel: AbstractHomeChildViewModel, modifier: Modifier): UIPostModel {
        return UIVideoPostModel(username, timestamp, avatar, video)
    }
}