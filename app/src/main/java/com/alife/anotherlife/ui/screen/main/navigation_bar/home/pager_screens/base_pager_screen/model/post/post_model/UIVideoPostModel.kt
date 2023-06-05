package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.media3.common.C
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable.VideoPlayerComposable
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel

data class UIVideoPostModel(
    override val username: String,
    override val timestamp: String,
    override val avatar: String? = null,
    val video: String
) : UIPostModel.Abstract() {

    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    override fun Card(
        exoPlayer: ExoPlayer,
        viewModel: AbstractHomeChildViewModel,
        modifier: Modifier
    ) {
        VideoPlayerComposable(exoPlayer, video, modifier.aspectRatio(328 / 480f))
    }
}