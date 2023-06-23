package com.alife.anotherlife.core.composable.brush

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun verticalPrimaryGradient() = Brush.verticalGradient(
    colors = listOf(
        MaterialTheme.colorScheme.background.copy(0.95f),
        Color.Transparent
    )
)