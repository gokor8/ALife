package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model

import android.net.Uri
import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import com.alife.anotherlife.theme.Shapes
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable.VideoPlayer
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable.VideoPlayerComposable
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.ExoPlayerSetupState
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.BlurCreateAlife
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.compose.PostCardCompose
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.state.HomeChildAction

abstract class AbstractUIVideoPostModel(
    override val username: String,
    override val timestamp: String,
    override val avatar: String? = null,
    val video: String
) : UIPostModel.Abstract() {

    @Composable
    fun Card(
        isNeedPlay: Boolean,
        viewModel: AbstractHomeChildViewModel,
        modifier: Modifier
    ) {
        PostCardCompose(
            username,
            timestamp,
            modifier,
            avatar = avatar,
            onProfileClick = {
                viewModel.reduce(HomeChildAction.OnPostProfile(username))
            }
        ) { newModifier -> VideoPlayer(viewModel, isNeedPlay, newModifier) }
    }

    @Composable
    protected open fun VideoPlayer(
        viewModel: AbstractHomeChildViewModel,
        isNeedPlay: Boolean,
        modifier: Modifier
    ) {
        VideoPlayerComposable(
            ExoPlayerSetupState.NeedPlayItem(
                //viewModel.getUIState().cacheDataSourceFactory,
                MediaItem.fromUri(Uri.parse(video))
            ),
            isNeedPlay,
            modifier
        )
    }
}

class UIVideoPostModel(
    username: String,
    timestamp: String,
    avatar: String? = null,
    video: String
) : AbstractUIVideoPostModel(username, timestamp, avatar, video)

class BlurUIVideoPostModel(
    username: String,
    timestamp: String,
    avatar: String? = null,
    video: String
) : AbstractUIVideoPostModel(username, timestamp, avatar, video) {

    @Composable
    override fun VideoPlayer(
        viewModel: AbstractHomeChildViewModel,
        isNeedPlay: Boolean,
        modifier: Modifier
    ) {
        BlurCreateAlife(
            modifier,
            viewModel::reduce,
        ) {
            super.VideoPlayer(viewModel, isNeedPlay, modifier)
        }
    }
}