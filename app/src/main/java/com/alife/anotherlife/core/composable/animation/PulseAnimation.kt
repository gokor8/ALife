package com.alife.anotherlife.core.composable.animation

import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset.Companion.Infinite
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun PulsingButton() {
    var pulse by remember { mutableStateOf(false) }

    val transition = updateTransition(targetState = pulse)

    val scale by transition.animateFloat(
        transitionSpec = {
            repeatable(
                iterations = AnimationConstants.Infinite,
                animation = tween(durationMillis = 500, easing = LinearEasing)
            )
        }, label = ""
    ) { isPulsing ->
        if (isPulsing) 1.2f else 1.0f
    }

    Button(
        onClick = {},
        modifier = Modifier
            .scale(scale)
            .clickable(onClick = { pulse = !pulse })
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Yellow
        ),
        content = { Text("Pulse") }
    )
}