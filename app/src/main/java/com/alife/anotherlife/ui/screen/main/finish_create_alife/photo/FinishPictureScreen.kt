package com.alife.anotherlife.ui.screen.main.finish_create_alife.photo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.alife_card.ALifeCardCompose
import com.alife.anotherlife.ui.screen.main.finish_create_alife.BaseCreateFinishScreen

class FinishPictureScreen(
    override val navController: NavController
) : BaseCreateFinishScreen<FinishPictureViewModel>(navController) {

    @Composable
    override fun InnerContent(modifier: Modifier) {
        val state = viewModel.getUIState()

        state.uiLocalPicturesModel?.apply {
            ALifeCardCompose(
                state.uiLocalPicturesModel,
                modifier = modifier,
                mainImageModifier = Modifier.fillMaxSize()
            )
        }
    }

    @Composable
    override fun setupViewModel(): FinishPictureViewModel = hiltViewModel()
}