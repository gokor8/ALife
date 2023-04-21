package com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
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
        MaterialTheme.colorScheme.apply {
            VideoCircle(
                onPrimary,
                onPrimary,
                primary,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .clickable(rememberCoroutineScope()) {

                    }
            )
        }
    }

    @Composable
    override fun InactiveContent() {
        MaterialTheme.colorScheme.apply {
            VideoCircle(
                onPrimary,
                onPrimary,
                primary,
                alpha = 0.5f,
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .clickable(rememberCoroutineScope()) {

                    }
            )
        }
    }

    @Composable
    fun VideoCircle(
        colorRing: Color,
        colorCircle: Color,
        colorSmallCircle: Color,
        alpha: Float = 1f,
        modifier: Modifier
    ) {
        Canvas(modifier = modifier) {
            drawCircle(color = colorRing.copy(alpha), style = stroke6Draw())
            drawCircle(color = colorCircle.copy(alpha), size.maxDimension / 2.5f)
            drawCircle(color = colorSmallCircle.copy(alpha), size.maxDimension / 20f)
        }
    }
}

@Preview
@Composable
fun VideoCirclePreview() {
    VideoCameraPagerItem().VideoCircle(
        Color.White,
        Color.White,
        Color.Black,
        modifier = Modifier.size(60.dp)
    )
}