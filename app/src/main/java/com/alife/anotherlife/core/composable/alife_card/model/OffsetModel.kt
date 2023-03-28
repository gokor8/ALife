package com.alife.anotherlife.core.composable.alife_card.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class OffsetModel(val offset: Float = 0f) {

    fun incrementCopy(incrementValue: Float): OffsetModel {
        return OffsetModel(offset + incrementValue)
    }

    @Composable
    fun calculateDp(): Dp = (offset / LocalDensity.current.density).dp
}