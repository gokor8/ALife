package com.alife.anotherlife.ui.screen.registration.base.chain.base

import androidx.annotation.StringRes
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer

interface ChainState {

    fun onChainResult(reducer: BaseValidationRegReducer)


    interface BaseSuccess : ChainState {

        override fun onChainResult(reducer: BaseValidationRegReducer) {
            reducer.onContinue()
        }
    }

    abstract class WithModelSuccess<M>(val inputModel: M) : BaseSuccess

    class Success : BaseSuccess

    class Fail(@StringRes private val resIdError: Int) : ChainState {

        override fun onChainResult(reducer: BaseValidationRegReducer) {
            reducer.onValidationError(resIdError)
        }
    }
}