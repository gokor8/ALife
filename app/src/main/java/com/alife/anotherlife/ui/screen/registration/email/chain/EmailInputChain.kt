package com.alife.anotherlife.ui.screen.registration.email.chain

import com.alife.anotherlife.ui.screen.registration.name.chain.FirstIsLetterTextChain
import com.alife.anotherlife.ui.screen.registration.name.chain.InputRegTextChain
import javax.inject.Inject

class EmailInputChain @Inject constructor(
    private val accessChars: CharArray,
    private val firstIsLetterTextChain: FirstIsLetterTextChain,
) : InputRegTextChain {

    override fun handle(inputModel: String) = firstIsLetterTextChain.handle(inputModel)
            && inputModel.all { char -> char.isLetter() || char.isDigit() || char in accessChars }
}