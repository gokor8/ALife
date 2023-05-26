package com.alife.anotherlife.ui.screen.main.finish_create_alife.video

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.ui.screen.DefaultScreen
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishAction
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishScreen
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.composable.VideoPlayerComposable
import com.alife.anotherlife.ui.screen.main.finish_create_alife.video.state.FinishVideoAction

class FinishVideoScreen(
    override val navController: NavController
) : BaseCreateFinishScreen<FinishVideoViewModel>(navController) {

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    override fun InnerContent(modifier: Modifier) {
        Card(
            modifier = modifier.padding(vertical = 30.dp, horizontal = 20.dp)
        ) {
            // TODO Add Video Preview
            val state = viewModel.getUIState()

            if(state.videoUrl.isNotEmpty()) VideoPlayerComposable(state.videoUrl)
        }
    }

    @Composable
    override fun setupViewModel(): FinishVideoViewModel = hiltViewModel()
}