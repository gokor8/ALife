package com.alife.anotherlife.core.composable.alife_card.start_strategy

import com.alife.anotherlife.core.composable.alife_card.model.DragSizeModel
import com.alife.anotherlife.core.composable.alife_card.model.OffsetContainerModel

class DefaultStrategy : StartStrategy {

    override fun createOffset(dragSizeModel: DragSizeModel): OffsetContainerModel {
        return OffsetContainerModel(0f, 0f)
    }
}