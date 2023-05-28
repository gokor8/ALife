package com.alife.anotherlife.ui.screen.registration.base.reducer

import androidx.annotation.StringRes
import com.alife.anotherlife.core.ui.reducer.AbstractVMReducer
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import com.alife.domain.registration.usecase.base.BaseRegStageUseCase

interface BaseValidationRegReducer {

    suspend fun onContinue()

    fun onValidationError(@StringRes errorResId: Int)


    abstract class Abstract(
        override val uiStore: UIStore<RegistrationState, RegistrationEffect>,
        private val saveBirthdayUseCase: BaseRegStageUseCase.Save<*>
    ) : HandlerBaseVMReducer<RegistrationState, RegistrationEffect>(), BaseValidationRegReducer {

        abstract suspend fun navigateNext()

        override suspend fun onContinue() {
            uiStore.setState { copy(textErrorModel = textErrorModel.copyEmptyError()) }

            saveBirthdayUseCase.saveData(getState().textErrorModel.getCurrentText())

            navigateNext()
        }

        override fun onValidationError(errorResId: Int) {
            uiStore.setState {
                copy(
                    textErrorModel = textErrorModel.copy(errorResId = errorResId)
                )
            }
        }
    }
}