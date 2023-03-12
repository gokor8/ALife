package com.alife.anotherlife.ui.screen.registration.username

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.core.composable.text.HintErrorTextOutlined
import com.alife.anotherlife.core.composable.text.text_formation.MaskVTDelegate
import com.alife.anotherlife.core.composable.text.text_formation.mask.patterns.UsernameDogPattern
import com.alife.anotherlife.ui.screen.registration.base.RegistrationViewModel
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationTextModel
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationAction

class UsernameRegTextModel : RegistrationTextModel {

    @Composable
    override fun TextOutlined(columnScope: ColumnScope, viewModel: RegistrationViewModel) {
        val maskVTDelegate = MaskVTDelegate(UsernameDogPattern()) { textFieldValue ->
            viewModel.reduce(RegistrationAction.OnTextInput(textFieldValue))
        }

        columnScope.HintErrorTextOutlined(
            textWithErrorModel = viewModel.getUIState().textWithErrorModel,
            onValueChange = maskVTDelegate::onValue,
            placeholderTextRes = viewModel.getUIState().registrationModel.helpText,
            visualTransformation = maskVTDelegate.createVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
    }
}