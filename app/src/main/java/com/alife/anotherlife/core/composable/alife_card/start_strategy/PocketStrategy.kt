package com.alife.anotherlife.core.composable.alife_card.start_strategy

import com.alife.anotherlife.core.composable.alife_card.model.DragSizeModel
import com.alife.anotherlife.core.composable.alife_card.model.OffsetContainerModel
import com.alife.anotherlife.core.composable.alife_card.model.OffsetModel

class PocketStrategy : StartStrategy {

    override fun createOffset(dragSizeModel: DragSizeModel): OffsetContainerModel {
        return OffsetContainerModel(
            OffsetModel(-(dragSizeModel.smallImageSize.width / 3f)),
            OffsetModel(dragSizeModel.mainImageSize.height / 2f)
        )
    }
}