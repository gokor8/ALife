package com.alife.anotherlife.core.composable.alife_card.mapper

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.DpSize
import com.alife.anotherlife.core.ui.ComposableMapper

class DpToPxSize(
    private val dpToPx: DpToPx = DpToPx()
) : ComposableMapper<DpSize, Size> {

    @Composable
    override fun map(value: DpSize): Size {
        return Size(dpToPx.map(value.width), dpToPx.map(value.height))
    }
}