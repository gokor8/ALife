package com.alife.anotherlife.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(14.dp),
    large = RoundedCornerShape(20.dp)
)

val TopShapes = Shapes(
    small = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
    medium = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
    large = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
)