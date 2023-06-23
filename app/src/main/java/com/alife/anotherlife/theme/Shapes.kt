package com.alife.anotherlife.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(22.dp)
)

val TopShapes = Shapes(
    small = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
    medium = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp),
    large = RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp)
)