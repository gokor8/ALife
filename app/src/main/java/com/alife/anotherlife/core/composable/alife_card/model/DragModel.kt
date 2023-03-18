package com.alife.anotherlife.core.composable.alife_card.model

import androidx.compose.runtime.MutableState
import androidx.compose.ui.geometry.Size
import com.alife.anotherlife.core.composable.alife_card.OffsetModel

class DragModel(
    val offsetX: MutableState<OffsetModel>,
    val offsetY: MutableState<OffsetModel>,
    val mainImageSize: Size,
    val smallImageSize: Size,
) {
    fun getOffsetX(): Float = offsetX.value.offset
    fun getOffsetY(): Float = offsetY.value.offset
}