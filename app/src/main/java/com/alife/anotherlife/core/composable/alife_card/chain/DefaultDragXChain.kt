package com.alife.anotherlife.core.composable.alife_card.chain

import com.alife.anotherlife.core.composable.alife_card.model.DragModel
import com.alife.core.chain.ChainHandler

class DefaultDragXChain : ChainHandler.Base<DragModel, Unit> {

    private val defaultValue: Float = 0f

    override fun handle(inputModel: DragModel) = with(inputModel) {
        val resultX = if (mainImageSize.width / 2f < offsetX.value.offset) {
            mainImageSize.width - smallImageSize.width
        } else {
            defaultValue
        }

        offsetX.value = offsetX.value.copy(offset = resultX)
        offsetY.value = offsetY.value.copy(offset = defaultValue)
    }
}