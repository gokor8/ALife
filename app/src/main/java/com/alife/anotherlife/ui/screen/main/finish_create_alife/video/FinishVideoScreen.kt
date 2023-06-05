package com.alife.anotherlife.ui.screen.main.finish_create_alife.video

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.media3.common.C
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.NavController
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishScreen
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable.VideoPlayerComposable

class FinishVideoScreen(
    override val navController: NavController
) : BaseCreateFinishScreen<FinishVideoViewModel>(navController) {

    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    override fun InnerContent(modifier: Modifier) {
        // TODO Add Video Preview

        viewModel.getUIState().videoUrl.takeIf { it.isNotEmpty() }?.also { url ->
            val context = LocalContext.current

            val exoPlayer = remember {
                ExoPlayer.Builder(context).build().apply {
                    //setMediaItem(mediaItem)
                    videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT
                    repeatMode = Player.REPEAT_MODE_ONE
                    playWhenReady = true
                    prepare()
                }
            }

            VideoPlayerComposable(exoPlayer, url, modifier)
        }
    }

    @Composable
    override fun setupViewModel(): FinishVideoViewModel = hiltViewModel()

}