package com.alife.anotherlife.ui.screen.registration.name.chain

import com.alife.core.chain.ChainHandler
import javax.inject.Inject

class FirstIsLetterTextChain @Inject constructor(): ChainHandler.Base<String, Boolean> {

    override fun handle(inputModel: String) = inputModel.isEmpty() ||
            inputModel.firstOrNull()?.isLetter() == true
}