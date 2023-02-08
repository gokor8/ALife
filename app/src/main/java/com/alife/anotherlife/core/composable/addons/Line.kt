package com.example.testnavigation.screens.core.compose_bases.other

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.example.testnavigation.ui.theme.Theme

@Composable
fun Line(
    modifier: Modifier = Modifier,
    color: Color = Theme.colors.Neutral_3,
    strokeWidth: Float = 1f
) {
    Canvas(modifier = modifier.fillMaxWidth()) {
        drawLine(color = color, Offset.Zero, Offset(size.width, 0f),strokeWidth = strokeWidth)
    }
}