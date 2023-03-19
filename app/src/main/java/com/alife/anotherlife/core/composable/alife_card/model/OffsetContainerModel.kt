package com.alife.anotherlife.core.composable.alife_card.model

import androidx.compose.runtime.Stable

@Stable
data class OffsetContainerModel(
    val offsetX: OffsetModel,
    val offsetY: OffsetModel,
) {

    constructor(x: Float, y: Float): this(OffsetModel(x), OffsetModel(y))

    fun incrementX(incrementValue: Float): OffsetContainerModel {
        return OffsetContainerModel(offsetX.incrementCopy(incrementValue), offsetY)
    }

    fun incrementY(incrementValue: Float): OffsetContainerModel {
        return OffsetContainerModel(offsetX, offsetY.incrementCopy(incrementValue))
    }
}