package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.core.composable.addons.stroke6Draw
import com.alife.anotherlife.core.composable.clickable
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper

class VideoCameraPagerItem : CreateAlifePagerItem {

    @Composable
    override fun Content(
        captureWrapper: BaseCaptureWrapper,
        viewModel: CreateAlifeViewModel
    ) {
        val colorScheme = MaterialTheme.colorScheme

        Canvas(modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
            .clickable(rememberCoroutineScope()) {

            }
        ) {
            drawCircle(color = colorScheme.onPrimary, style = stroke6Draw())
            drawCircle(color = colorScheme.onPrimary, size.maxDimension / 2.5f)
            drawCircle(color = colorScheme.primary, 20f)
        }
    }
}