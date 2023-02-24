package com.alife.anotherlife.ui.screen.registration.base.chain.base

import androidx.annotation.StringRes
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer

interface ChainState {

    fun onChainResult(reducer: BaseValidationRegReducer)


    class Success : ChainState {

        override fun onChainResult(reducer: BaseValidationRegReducer) {
            reducer.onContinue()
        }
    }

    class Fail(@StringRes private val resIdError: Int) : ChainState {

        override fun onChainResult(reducer: BaseValidationRegReducer) {
            reducer.onValidationError(resIdError)
        }
    }
}