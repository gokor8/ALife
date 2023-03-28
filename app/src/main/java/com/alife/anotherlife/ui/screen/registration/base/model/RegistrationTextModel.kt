package com.alife.anotherlife.ui.screen.registration.base.model

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.composable.text.HintErrorTextOutlined
import com.alife.anotherlife.ui.screen.registration.base.RegistrationViewModel
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationAction

interface RegistrationTextModel {

    @Composable
    fun TextOutlined(columnScope: ColumnScope, viewModel: RegistrationViewModel)


    class Default : RegistrationTextModel {

        @Composable
        override fun TextOutlined(columnScope: ColumnScope, viewModel: RegistrationViewModel) {
            columnScope.HintErrorTextOutlined(
                textErrorModel = viewModel.getUIState().textErrorModel,
                onValueChange = { newTextFieldValue ->
                    viewModel.reduce(RegistrationAction.OnTextInput(newTextFieldValue))
                },
                placeholderTextRes = viewModel.getUIState().registrationModel.helpText,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}