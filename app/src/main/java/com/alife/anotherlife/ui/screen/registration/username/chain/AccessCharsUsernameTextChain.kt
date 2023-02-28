package com.alife.anotherlife.ui.screen.registration.username.chain

import javax.inject.Inject

class AccessCharsUsernameTextChain @Inject constructor(
    private val accessSymbols: CharArray,
    private val usernameMaxTextChain: UsernameRegTextChain
) : UsernameRegTextChain {

    override fun handle(inputModel: String): Boolean {
        return inputModel.all { char ->
            char.isLetter() || char.isDigit() || accessSymbols.contains(char)
        } && usernameMaxTextChain.handle(inputModel)
    }
}