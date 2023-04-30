package com.alife.anotherlife.ui.screen.main.create_alife.composable

import android.animation.ObjectAnimator
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        drawCircle(color = colorSmallCircle.copy(alpha), size.maxDimension / 10f)
    }
}