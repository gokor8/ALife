package com.alife.anotherlife.ui.screen.main.create_alife.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.alife.anotherlife.core.composable.addons.ColorWrapper
import com.alife.anotherlife.core.composable.addons.stroke6Draw
import com.alife.anotherlife.core.composable.clickable

@Composable
fun CameraCircleComposable(
    color: Color,
    size: Dp,
    enabled: Boolean = true,
    onClick: suspend () -> Unit
) {
    val colorWrapper = if (enabled) ColorWrapper() else ColorWrapper(0.5f)

    Canvas(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .clickable(rememberCoroutineScope(), onClick = onClick)
    ) {
        drawCircle(
            color = colorWrapper.color(color),
            style = stroke6Draw()
        )
    }
}