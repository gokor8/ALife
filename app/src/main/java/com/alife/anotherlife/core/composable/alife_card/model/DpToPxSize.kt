package com.alife.anotherlife.core.composable.alife_card.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import com.alife.anotherlife.core.composable.alife_card.DpToPx
import com.alife.anotherlife.core.ui.ComposableMapper

class DpToPxSize(
    private val dpToPx: DpToPx
) : ComposableMapper<DpSize, Size> {

    @Composable
    override fun map(value: DpSize): Size {
        return Size(dpToPx.map(value.width), dpToPx.map(value.height))
    }
}