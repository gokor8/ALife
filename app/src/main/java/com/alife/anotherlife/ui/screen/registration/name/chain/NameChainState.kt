package com.alife.anotherlife.ui.screen.registration.name.chain

import androidx.annotation.StringRes
import com.alife.anotherlife.ui.screen.registration.name.reducer.BaseValidationNameRegReducer

interface NameChainState {

    fun onChainResult(reducer: BaseValidationNameRegReducer)


    class Success : NameChainState {

        override fun onChainResult(reducer: BaseValidationNameRegReducer) {
            reducer.onContinue()
        }
    }

    class Fail(@StringRes private val resIdError: Int) : NameChainState {

        override fun onChainResult(reducer: BaseValidationNameRegReducer) {
            reducer.onValidationError(resIdError)
        }
    }

}