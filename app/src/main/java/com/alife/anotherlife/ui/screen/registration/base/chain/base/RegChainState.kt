package com.alife.anotherlife.ui.screen.registration.base.chain.base

import androidx.annotation.StringRes
import com.alife.anotherlife.ui.screen.registration.base.reducer.BaseValidationRegReducer
import com.alife.core.chain.BaseChainState

interface RegChainState : BaseChainState {

    suspend fun onChainResult(reducer: BaseValidationRegReducer)


    interface BaseSuccess : RegChainState, BaseChainState.Success {

        override suspend fun onChainResult(reducer: BaseValidationRegReducer) {
            reducer.onContinue()
        }
    }

    abstract class WithModelSuccess<M>(val inputModel: M) : BaseSuccess

    class Success : BaseSuccess

    class Fail(@StringRes private val resIdError: Int) : RegChainState, BaseChainState.Fail {

        override suspend fun onChainResult(reducer: BaseValidationRegReducer) {
            reducer.onValidationError(resIdError)
        }
    }
}