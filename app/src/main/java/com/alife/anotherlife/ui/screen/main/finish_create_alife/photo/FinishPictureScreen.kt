package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.alife_card.ALifeCardCompose
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishScreen

class FinishPictureScreen(
    override val navController: NavController
) : BaseCreateFinishScreen<FinishPictureViewModel>(navController) {

    @Composable
    override fun InnerContent(modifier: Modifier) {
        Card(
            modifier = modifier.padding(vertical = 30.dp, horizontal = 20.dp)
        ) {
            // TODO Add Video Preview
            val state = viewModel.getUIState()

            if (state.isUrlsValid()) ALifeCardCompose(state.firstImageUrl, state.secondImageUrl)
        }
    }

    @Composable
    override fun setupViewModel(): FinishPictureViewModel = hiltViewModel()
}