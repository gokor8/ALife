package com.alife.anotherlife.core.composable.text.style

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

abstract class TitleTextStyle(
    private val fontSize: TextUnit,
    private val fontWeight: FontWeight,
    private val color: Color = Color.Unspecified,
) : BaseTextStyle {

    override fun style(): TextStyle = TextStyle(
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
}