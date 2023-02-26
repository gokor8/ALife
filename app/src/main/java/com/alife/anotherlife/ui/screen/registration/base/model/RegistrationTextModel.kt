package com.alife.anotherlife.ui.screen.registration.base.model

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.composable.text.HintTextOutlined
import com.alife.anotherlife.ui.screen.registration.base.RegistrationViewModel
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationAction

interface RegistrationTextModel {

    @Composable
    fun TextOutlined(columnScope: ColumnScope, viewModel: RegistrationViewModel)


    class Default : RegistrationTextModel {

        @Composable
        override fun TextOutlined(columnScope: ColumnScope, viewModel: RegistrationViewModel) {
            columnScope.HintTextOutlined(
                textWithErrorModel = viewModel.getUIState().textWithErrorModel,
                onValueChange = { newText ->
                    viewModel.reduce(RegistrationAction.OnTextInput(newText.text))
                },
                placeholderTextRes = viewModel.getUIState().registrationModel.helpText,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}