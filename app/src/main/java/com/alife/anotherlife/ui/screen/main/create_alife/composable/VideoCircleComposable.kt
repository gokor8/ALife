package com.alife.anotherlife.ui.screen.main.create_alife.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.core.composable.addons.stroke6Draw

@Composable
fun VideoCircleComposable(
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

@Composable
fun VideoOnRecordingComposable(
    colorRing: Color,
    colorSmallCircle: Color,
    alpha: Float = 1f,
    modifier: Modifier
) {
    Canvas(modifier = modifier) {
        drawCircle(color = colorRing.copy(alpha), style = stroke6Draw())

        val rectSize = size / 2f
        drawRoundRect(
            color = colorSmallCircle.copy(alpha),
            cornerRadius = CornerRadius(10f, 10f),
            size = rectSize,
            topLeft = Offset(
                size.width / 2f - rectSize.width / 2f,
                size.height / 2f - rectSize.height / 2f
            )
        )
    }
}