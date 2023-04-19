package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.core.composable.addons.stroke6Draw
import com.alife.anotherlife.core.composable.clickable
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction

interface CameraPagerItem : CreateAlifePagerItem {

    class TakePicture : CameraPagerItem {

        @Composable
        override fun Content(
            captureWrapper: BaseCaptureWrapper,
            viewModel: CreateAlifeViewModel
        ) {
            val colorScheme = MaterialTheme.colorScheme
            val context = LocalContext.current

            Canvas(modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .clickable(rememberCoroutineScope()) {
                    viewModel.reduce(CreateAlifeAction.ChangeCameraPagerItem(OnPictureTaking()))
                    val imageProxy = captureWrapper.takePhoto(context)
                    viewModel.reduce(CreateAlifeAction.TakePhoto(imageProxy))
                }
            ) {
                drawCircle(
                    color = colorScheme.onPrimary,
                    style = stroke6Draw()
                )
            }
        }
    }

    class OnPictureTaking : CameraPagerItem {

        @Composable
        override fun Content(
            captureWrapper: BaseCaptureWrapper,
            viewModel: CreateAlifeViewModel
        ) {
            CircularProgressIndicator(strokeWidth = 2.dp)
        }
    }
}