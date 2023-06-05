package com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.model.post.post_model

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.composable.text.style.Title20Style
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable.VideoPlayerComposable
import com.alife.anotherlife.ui.screen.main.navigation_bar.home.pager_screens.base_pager_screen.AbstractHomeChildViewModel

data class UIVideoPostModel(
    override val username: String,
    override val timestamp: String,
    override val avatar: String? = null,
    val video: String
) : UIPostModel.Abstract() {

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    override fun Card(viewModel: AbstractHomeChildViewModel, modifier: Modifier) {
        VideoPlayerComposable(videoUrl = video, modifier.aspectRatio(328 / 480f))
        //Text("Video", style = Title20Style().style())
    }
}