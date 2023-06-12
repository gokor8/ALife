package com.alife.anotherlife.core.composable.text.style

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

fun style16(color: Color = Color.Unspecified) = TextStyle(fontSize = 16.sp, color = color)

fun style16Bold(color: Color = Color.Unspecified) =
    TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Unspecified)

fun style18Bold() = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)

fun style36Bold(color: Color = Color.Unspecified) = TextStyle(
    fontSize = 36.sp,
    fontWeight = FontWeight.Bold,
    color = color
)