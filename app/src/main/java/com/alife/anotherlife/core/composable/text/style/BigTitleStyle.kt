package com.alife.anotherlife.core.composable.text.style

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

class BigTitleStyle : BaseTextStyle {

    private val fontSize = 28.sp

    override fun style(): TextStyle = TextStyle(fontSize = fontSize)
}