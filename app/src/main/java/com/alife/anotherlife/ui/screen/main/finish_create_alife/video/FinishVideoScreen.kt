package com.alife.anotherlife.ui.screen.main.finish_create_alife.video

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishScreen
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable.VideoPlayerComposable

class FinishVideoScreen(
    override val navController: NavController
) : BaseCreateFinishScreen<FinishVideoViewModel>(navController) {

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    override fun InnerContent(modifier: Modifier) {
        // TODO Add Video Preview

        viewModel.getUIState().videoUrl.takeIf { it.isNotEmpty() }?.also { url ->
            VideoPlayerComposable(url, modifier)
        }
    }

    @Composable
    override fun setupViewModel(): FinishVideoViewModel = hiltViewModel()
}