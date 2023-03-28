package com.alife.anotherlife.ui.screen.registration.base.reducer

import androidx.compose.ui.text.input.TextFieldValue
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationEffect
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationState

abstract class RegistrationReducer(
    override val uiStore: UIStore<RegistrationState, RegistrationEffect>,
) : BaseVMReducer<RegistrationState, RegistrationEffect>(), BaseRegistrationReducer {

    override fun onTextInput(textFieldValue: TextFieldValue) {
        uiStore.setState {
            copy(textErrorModel = textErrorModel.copyEmptyError(textFieldValue))
        }
    }
}