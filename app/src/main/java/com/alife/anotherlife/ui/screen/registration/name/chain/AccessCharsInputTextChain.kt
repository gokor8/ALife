package com.alife.anotherlife.ui.screen.registration.name.chain

import com.alife.anotherlife.ui.screen.registration.base.chain.base.RegChainState
import javax.inject.Inject

class AccessCharsInputTextChain @Inject constructor(
    private val maxNameTextChain: MaxNameTextChain,
    private val whitespaceTextChain: FirstIsLetterTextChain
) : InputRegTextChain {

    override fun handle(inputModel: String): Boolean {
        val isNotMaxLength = maxNameTextChain.handle(inputModel) is RegChainState.Success

        return inputModel.all { char ->
            char.isLetter() || char.isWhitespace()
        } && isNotMaxLength && whitespaceTextChain.handle(inputModel)
    }
}