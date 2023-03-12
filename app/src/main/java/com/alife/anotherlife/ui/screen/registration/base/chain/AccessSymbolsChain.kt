package com.alife.anotherlife.ui.screen.registration.base.chain

import com.alife.core.chain.ChainHandler
import javax.inject.Inject

class AccessSymbolsChain @Inject constructor(
    private val accessSymbols: CharArray,
) : ChainHandler.Base<String, Boolean> {

    override fun handle(inputModel: String) = inputModel.all { char ->
        char.isLetter() || char.isDigit() || char in accessSymbols
    }
}