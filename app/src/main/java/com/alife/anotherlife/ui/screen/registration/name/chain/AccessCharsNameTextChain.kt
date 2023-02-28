package com.alife.anotherlife.ui.screen.registration.name.chain

import com.alife.anotherlife.ui.screen.registration.base.chain.base.ChainState
import javax.inject.Inject

class AccessCharsNameTextChain @Inject constructor(
    private val maxNameTextChain: MaxNameTextChain,
) : NameRegTextChain {

    override fun handle(inputModel: String): Boolean {
        val isFirstNotWhitespace = inputModel.firstOrNull()?.isWhitespace() != true
        val isNotMaxLength = maxNameTextChain.handle(inputModel) is ChainState.Success

        return inputModel.all { char ->
            char.isLetter() || char.isWhitespace()
        } && isNotMaxLength && isFirstNotWhitespace
    }
}