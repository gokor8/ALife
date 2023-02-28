package com.alife.anotherlife.ui.screen.registration.username

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.alife.anotherlife.core.composable.text.HintErrorTextOutlined
import com.alife.anotherlife.core.composable.text.text_formation.MaskVTDelegate
import com.alife.anotherlife.core.composable.text.text_formation.mask.patterns.BirthdayPattern
import com.alife.anotherlife.ui.screen.registration.base.RegistrationViewModel
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationTextModel
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationAction
import com.alife.anotherlife.ui.screen.registration.username.model.UsernameDogVisualTransformation

class UsernameRegTextModel : RegistrationTextModel {

    @Composable
    override fun TextOutlined(columnScope: ColumnScope, viewModel: RegistrationViewModel) {
        columnScope.HintErrorTextOutlined(
            textWithErrorModel = viewModel.getUIState().textWithErrorModel,
            onValueChange = { textFieldValue ->
                viewModel.reduce(RegistrationAction.OnTextInput(textFieldValue))
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholderTextRes = viewModel.getUIState().registrationModel.helpText,
            visualTransformation = UsernameDogVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}