package com.alife.anotherlife.ui.screen.registration.base.reducer

import androidx.annotation.StringRes
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState

interface BaseValidationRegReducer {

    suspend fun onContinue()

    fun onValidationError(@StringRes errorResId: Int)


    abstract class Abstract(
        override val uiStore: UIStore<RegistrationState, RegistrationEffect>
    ) : BaseVMReducer<RegistrationState, RegistrationEffect>(), BaseValidationRegReducer {

        abstract suspend fun navigateNext()

        override suspend fun onContinue() {
            uiStore.setState { copy(textWithErrorModel = textWithErrorModel.copyEmptyError()) }
            navigateNext()
        }

        override fun onValidationError(errorResId: Int) {
            uiStore.setState {
                copy(
                    textWithErrorModel = textWithErrorModel.copy(errorResId = errorResId)
                )
            }
        }
    }
}