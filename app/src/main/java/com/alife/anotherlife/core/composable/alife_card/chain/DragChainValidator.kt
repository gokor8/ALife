package com.alife.anotherlife.core.composable.alife_card.chain

import com.alife.anotherlife.core.composable.alife_card.model.DragModel
import com.alife.core.chain.ChainHandler

class DragChainValidator(
    private val booleanDragChainHandler: ChainHandler.Base<DragModel, Boolean>,
    private val dragChainHandler: ChainHandler.Base<DragModel, Unit>
) : ChainHandler.Base<DragModel, Unit> {

    override fun handle(inputModel: DragModel) {
        val isDragged = booleanDragChainHandler.handle(inputModel)

        if(!isDragged) dragChainHandler.handle(inputModel)
    }
}