package com.alife.anotherlife.core.composable.brush

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun verticalBottomToTopGradient() = Brush.verticalGradient(
    listOf(
        Color.Transparent,
        MaterialTheme.colorScheme.background
    )
)

@Composable
fun verticalTopToBottomGradient() = Brush.verticalGradient(
    listOf(
        MaterialTheme.colorScheme.background,
        Color.Transparent,
    )
)