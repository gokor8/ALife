package com.alife.anotherlife.core.composable.alife_card.model

import androidx.compose.ui.geometry.Size

class DragModel(
    val offsetContainerModel: OffsetContainerModel,
    val mainImageSize: Size,
    val smallImageSize: Size,
) {
    fun getOffsetX(): Float = offsetContainerModel.offsetX.offset
    fun getOffsetY(): Float = offsetContainerModel.offsetY.offset
}