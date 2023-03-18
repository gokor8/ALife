package com.alife.anotherlife.core.composable.alife_card.chain

import com.alife.anotherlife.core.composable.alife_card.model.DragModel
import com.alife.anotherlife.core.composable.alife_card.model.OffsetContainerModel
import com.alife.core.chain.ChainHandler

class DragChainValidator(
    private val booleanDragChainHandler: ChainHandler.Base<DragModel, OffsetContainerModel>,
    private val dragChainHandler: ChainHandler.Base<DragModel, OffsetContainerModel>
) : ChainHandler.Base<DragModel, OffsetContainerModel> {

    override fun handle(inputModel: DragModel): OffsetContainerModel {
        val newOffsetContainer = booleanDragChainHandler.handle(inputModel)

        return if(inputModel.offsetContainerModel == newOffsetContainer)
            dragChainHandler.handle(inputModel)
        else
            newOffsetContainer
    }
}