package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.container

import android.net.Uri
import android.provider.MediaStore
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable.VideoPlayer
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable.VideoPlayerComposable
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.ExoPlayerSetupState
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model.UIVideoPostModel

class VideoPostContainerUI(
    override val username: String,
    override val timestamp: String,
    override val avatar: String? = null,
    private val video: String
) : UIBasePostContainer.Abstract() {

    @Composable
    fun Post(
        isNeedPlay: Boolean,
        viewModel: AbstractHomeChildViewModel,
        modifier: Modifier
    ) {
//        VideoPlayerComposable(
//            ExoPlayerSetupState.NeedPlayItem(MediaItem.fromUri(Uri.parse(video))),
//            modifier.aspectRatio(328 / 480f)
//        )

//        VideoPlayer(
//            uri = Uri.parse(video),
//            ExoPlayerSetupState.NeedPlayItem(MediaItem.fromUri(Uri.parse(video))),
//            modifier = Modifier.height(328.dp),
//            true
//        )
//        if (viewModel.getUIState().isHavePostToday) {
//            clear(viewModel = viewModel, modifier = modifier)
//        } else {
//            blur(viewModel = viewModel, modifier = modifier)
//        }.Card(isNeedPlay, viewModel, modifier)

        UIVideoPostModel(username, timestamp, avatar, video).Card(isNeedPlay, viewModel, modifier)
    }

    @Composable
    override fun clear(viewModel: AbstractHomeChildViewModel, modifier: Modifier): UIVideoPostModel {
        return UIVideoPostModel(username, timestamp, avatar, video)
    }

    @Composable
    override fun blur(viewModel: AbstractHomeChildViewModel, modifier: Modifier): UIVideoPostModel {
        return UIVideoPostModel(username, timestamp, avatar, video)
    }
}