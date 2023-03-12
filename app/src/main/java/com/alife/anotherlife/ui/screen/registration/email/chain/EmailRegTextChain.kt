package com.alife.anotherlife.ui.screen.registration.email.chain

import android.util.Patterns
import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.registration.base.chain.DefaultRegChain
import com.alife.anotherlife.ui.screen.registration.base.chain.base.BaseRegTextChain
import javax.inject.Inject

class EmailRegTextChain @Inject constructor() : DefaultRegChain<String>(R.string.invalid_email),
    BaseRegTextChain {

    override fun condition(inputModel: String) =
        Patterns.EMAIL_ADDRESS.matcher(inputModel).matches()
}