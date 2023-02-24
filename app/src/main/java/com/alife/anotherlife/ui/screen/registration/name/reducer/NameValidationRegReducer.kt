package com.alife.anotherlife.ui.screen.registration.name.reducer

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState
import javax.inject.Inject

class NameValidationRegReducer @Inject constructor(
    override val uiStore: UIStore<RegistrationState, RegistrationEffect>
) : BaseVMReducer<RegistrationState, RegistrationEffect>(), BaseValidationNameRegReducer {

    override fun onContinue() {
        uiStore.setState { copy(textWithErrorModel = textWithErrorModel.copyEmptyError()) }
        uiStore.trySetEffect(RegistrationEffect.NavigateUsername())
    }

    override fun onValidationError(errorResId: Int) {
        uiStore.setState {
            copy(
                textWithErrorModel = textWithErrorModel.copy(errorResId = errorResId)
            )
        }
    }
}