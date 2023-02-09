package com.alife.anotherlife.core.composable.addons

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

@Composable
fun Line(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    strokeWidth: Float = 1f
) {
    Canvas(modifier = modifier.fillMaxWidth()) {
        drawLine(color = color, Offset.Zero, Offset(size.width, 0f),strokeWidth = strokeWidth)
    }
}