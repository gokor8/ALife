package com.alife.anotherlife.core.composable.alife_card.chain

import com.alife.anotherlife.core.composable.alife_card.model.DragModel
import com.alife.anotherlife.core.composable.alife_card.model.OffsetContainerModel
import com.alife.anotherlife.core.composable.alife_card.model.OffsetModel
import com.alife.core.chain.ChainHandler

class DefaultDragXChain : ChainHandler.Base<DragModel, OffsetContainerModel> {

    private val defaultValue: Float = 0f

    override fun handle(inputModel: DragModel) = with(inputModel) {
        val resultX = if (mainImageSize.width / 2f < getOffsetX()) {
            mainImageSize.width - smallImageSize.width
        } else {
            defaultValue
        }

        return@with OffsetContainerModel(
            OffsetModel(resultX),
            OffsetModel(defaultValue),
        )
    }
}