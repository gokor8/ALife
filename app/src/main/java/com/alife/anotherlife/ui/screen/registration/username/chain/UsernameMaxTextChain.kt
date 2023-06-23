package com.alife.anotherlife.ui.screen.registration.username.chain

import javax.inject.Inject

class UsernameMaxTextChain @Inject constructor() : UsernameRegTextChain {

    override fun handle(inputModel: String): Boolean = inputModel.length < 15
}