package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state

import androidx.camera.core.CameraSelector
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.composable.CameraPreviewComposable
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.CameraSetupFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction

abstract class CameraScreenState(
    val cameraSelector: CameraSelector,
    private
) : ScreenState.AbstractScreenState() {

    @Composable
    override fun Content(
        viewModel: CreateAlifeViewModel,
        modifier: Modifier,
    ) {
        Box(
            contentAlignment = contentAlignment,
            modifier = Modifier.fillMaxSize()
        ) {
            SafeContent(viewModel = viewModel)
            TopRowContent(viewModel, modifier)
        }
    }

    @Composable
    override fun SafeContent(viewModel: CreateAlifeViewModel) {
        val cameraFacade = CameraSetupFactory().create(cameraSelector)

        CameraPreviewComposable(
            cameraFacade,
            modifier = Modifier.fillMaxSize()
        ) { viewModel.reduce(CreateAlifeAction.OnCaptureWrapper(it)) }
    }

    @Composable
    override fun TopRowContent(
        viewModel: CreateAlifeViewModel,
        modifier: Modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxWidth()
        ) {
            TextBase(
                textResId = R.string.horizontal_short_logo,
                style = Title28Style().style(),
                modifier = Modifier.padding(top = 22.dp)
            )
        }
    }
}

