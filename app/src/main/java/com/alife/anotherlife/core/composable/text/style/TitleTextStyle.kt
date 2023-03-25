package com.alife.anotherlife.core.composable.text.style

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

abstract class TitleTextStyle(
    private val fontSize: TextUnit,
    private val fontWeight: FontWeight
) : BaseTextStyle {

    override fun style(): TextStyle = TextStyle(
        color = Color.Unspecified,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
}