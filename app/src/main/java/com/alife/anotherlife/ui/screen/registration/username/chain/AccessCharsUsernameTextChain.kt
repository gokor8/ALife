package com.alife.anotherlife.ui.screen.registration.username.chain

import com.alife.anotherlife.ui.screen.registration.base.chain.AccessSymbolsChain
import com.alife.anotherlife.ui.screen.registration.name.chain.FirstIsLetterTextChain
import javax.inject.Inject

class AccessCharsUsernameTextChain @Inject constructor(
    private val accessSymbolsChain: AccessSymbolsChain,
    private val usernameMaxTextChain: UsernameRegTextChain,
    private val whitespaceTextChain: FirstIsLetterTextChain
) : UsernameRegTextChain {

    override fun handle(inputModel: String): Boolean {
        return accessSymbolsChain.handle(inputModel) && usernameMaxTextChain.handle(inputModel)
                && whitespaceTextChain.handle(inputModel)
    }
}