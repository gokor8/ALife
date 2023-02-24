package com.alife.anotherlife.ui.screen.registration.name.chain

import javax.inject.Inject

class NameChainValidator @Inject constructor() : BaseNameChainValidator {

    override fun handle(inputModel: String): NameChainState {
        val chainResult = MinNameChain().handle(inputModel)

        return if(chainResult is NameChainState.Success)
            MaxNameChain().handle(inputModel)
        else
            chainResult
    }
}