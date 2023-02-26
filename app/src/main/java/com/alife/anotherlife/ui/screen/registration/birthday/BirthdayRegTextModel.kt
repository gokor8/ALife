package com.alife.anotherlife.ui.screen.registration.birthday

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.alife.anotherlife.core.composable.text.HintTextOutlined
import com.alife.anotherlife.core.composable.text.text_formation.MaskVTDelegate
import com.alife.anotherlife.core.composable.text.text_formation.MaskVisualTransformation
import com.alife.anotherlife.core.composable.text.text_formation.mask.patterns.BirthdayPattern
import com.alife.anotherlife.ui.screen.registration.base.RegistrationViewModel
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationTextModel
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationAction

class BirthdayRegTextModel : RegistrationTextModel {

    @Composable
    override fun TextOutlined(columnScope: ColumnScope, viewModel: RegistrationViewModel) {
        val birthdayMask = BirthdayPattern().getMaskPattern()
        //val maskVTDelegate = MaskVTDelegate(BirthdayPattern().getMaskPattern()) { newText ->
        //    viewModel.reduce(RegistrationAction.OnTextInput(newText.text))
        //}

        columnScope.HintTextOutlined(
            textWithErrorModel = viewModel.getUIState().textWithErrorModel,
            onValueChange = { newText ->
                viewModel.reduce(RegistrationAction.OnTextInput(newText))
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            visualTransformation = MaskVisualTransformation(birthdayMask),
            placeholderTextRes = viewModel.getUIState().registrationModel.helpText,
            modifier = Modifier.fillMaxWidth()
        )
    }
}