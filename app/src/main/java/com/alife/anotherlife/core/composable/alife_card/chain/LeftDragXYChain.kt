package com.alife.anotherlife.core.composable.alife_card.chain

import android.util.Log
import com.alife.anotherlife.core.composable.alife_card.model.DragModel
import com.alife.anotherlife.core.composable.alife_card.model.DragSizeModel
import com.alife.anotherlife.core.composable.alife_card.model.OffsetContainerModel
import com.alife.anotherlife.core.composable.alife_card.start_strategy.PocketStrategy
import com.alife.core.chain.ChainHandler

class LeftDragXYChain : ChainHandler.Base<DragModel, OffsetContainerModel> {

    override fun handle(inputModel: DragModel) = with(inputModel) {
        // Log.d("LeftDragXYChain", "condition: $condition")

        Log.d("LeftDragXYChain", "offsetXC: ${0f} | offsetYC:${mainImageSize.height / 2f}")
        Log.d("LeftDragXYChain", "offsetX: ${getOffsetX()} | offsetY:${getOffsetY()}")

        // когда верну offset модели из цепочки, проверить на хеши, если не равны, записывать значение
        // return offsets models, delete mutableState
        return@with if (getOffsetX() <= 0f && getOffsetY() > mainImageSize.height / 2f) {
            PocketStrategy().createOffset(
                DragSizeModel(mainImageSize, smallImageSize)
            )
        } else {
            inputModel.offsetContainerModel
        }
    }
}