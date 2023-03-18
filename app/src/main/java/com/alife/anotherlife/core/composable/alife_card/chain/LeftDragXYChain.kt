package com.alife.anotherlife.core.composable.alife_card.chain

import android.util.Log
import com.alife.anotherlife.core.composable.alife_card.OffsetModel
import com.alife.anotherlife.core.composable.alife_card.model.DragModel
import com.alife.core.chain.ChainHandler

class LeftDragXYChain : ChainHandler.Base<DragModel, Boolean> {

    override fun handle(inputModel: DragModel) = with(inputModel) {
        val condition = getOffsetX() <= 0f && getOffsetY() > mainImageSize.height / 2f
        Log.d("LeftDragXYChain", "condition: $condition")

        Log.d("LeftDragXYChain", "offsetXC: ${0f} | offsetYC:${mainImageSize.height / 2f}")
        Log.d("LeftDragXYChain", "offsetX: ${getOffsetX()} | offsetY:${getOffsetY()}")

        // return offsets models, delete mutableState
        if(condition) {
            offsetX.value = OffsetModel(-(smallImageSize.width / 2f))
            offsetY.value = OffsetModel(mainImageSize.height / 2f)
        }

        return@with condition
    }
}