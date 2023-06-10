package com.alife.anotherlife.ui.screen.main.finish_create_alife.video

import android.net.Uri
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishScreen
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable.VideoPlayerComposable
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.model.ExoPlayerSetupState

class FinishVideoScreen(
    override val navController: NavController
) : BaseCreateFinishScreen<FinishVideoViewModel>(navController) {

    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    @Composable
    override fun InnerContent(modifier: Modifier) {
        // TODO Add Video Preview

        viewModel.getUIState().videoUrl.takeIf { it.isNotEmpty() }?.also { url ->
            VideoPlayerComposable(
                ExoPlayerSetupState.NeedPlayItem(
                    MediaItem.Builder().setUri(url).build()
                ), modifier
            )
        }
    }

    @Composable
    override fun setupViewModel(): FinishVideoViewModel = hiltViewModel()

}