package com.alife.anotherlife.core.composable.addons

import androidx.compose.ui.graphics.Color

class ColorWrapper(private val alpha: Float = 1f) {

    fun color(color: Color): Color = color.copy(alpha)
}