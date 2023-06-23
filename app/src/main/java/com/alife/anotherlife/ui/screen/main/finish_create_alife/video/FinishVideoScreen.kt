package com.alife.anotherlife.ui.screen.main.finish_create_alife.video

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.media3.common.MediaItem
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
                    //viewModel.cacheDataSourceFactory,
                    MediaItem.fromUri(url)
                ), true, modifier
            )
        }
    }

    @Composable
    override fun setupViewModel(): FinishVideoViewModel = hiltViewModel()

}