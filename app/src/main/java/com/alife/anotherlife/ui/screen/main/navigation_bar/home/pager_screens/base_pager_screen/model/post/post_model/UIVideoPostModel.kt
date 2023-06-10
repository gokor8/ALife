package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model

import android.net.Uri
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable.VideoPlayerComposable
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.ExoPlayerSetupState
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel


class UIVideoPostModel(
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
        val source = if (isNeedPlay) {
            ExoPlayerSetupState.NeedPlayItem(MediaItem.fromUri(Uri.parse(video)))
        } else {
            ExoPlayerSetupState.Pause
            // TODO пофиксить определятор позиции видео, так же жц для пейджер скринов
            ExoPlayerSetupState.NeedPlayItem(MediaItem.fromUri(Uri.parse(video)))
        }

        VideoPlayerComposable(
            source,
            modifier.aspectRatio(328 / 480f)
        )
    }
}