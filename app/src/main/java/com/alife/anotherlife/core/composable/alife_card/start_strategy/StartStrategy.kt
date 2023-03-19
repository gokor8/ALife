package com.alife.anotherlife.core.composable.alife_card.start_strategy

import com.alife.anotherlife.core.composable.alife_card.model.DragSizeModel
import com.alife.anotherlife.core.composable.alife_card.model.OffsetContainerModel

interface StartStrategy {

    fun createOffset(dragSizeModel: DragSizeModel): OffsetContainerModel
}