package com.alife.anotherlife.ui.screen.registration.base

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.HintTextOutlined
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.core.composable.text.style.Title22Style
import com.alife.anotherlife.core.composable.view_group.CustomColumn
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationAction

abstract class RegistrationScreen(
    private val visualTransformation: VisualTransformation = VisualTransformation.None,
) : VMScreen<RegistrationViewModel>() {

    @Composable
    override fun Content(modifier: Modifier) = CustomColumn(
        modifier = modifier.padding(horizontal = 32.dp, vertical = 35.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 28.dp)
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextBase(
                textResId = viewModel.getUIState().registrationModel.hintText,
                textAlign = TextAlign.Start,
                style = Title22Style().style(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(bottom = 25.dp))

            HintTextOutlined(
                textWithErrorModel = viewModel.getUIState().textWithErrorModel,
                onValueChange = { newText ->
                    viewModel.reduce(RegistrationAction.OnTextInput(newText))
                },
                visualTransformation = visualTransformation,
                placeholderTextRes = viewModel.getUIState().registrationModel.helpText,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            TextBase(
                textResId = R.string.horizontal_logo,
                style = Title28Style().style(),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(bottom = 25.dp))

            Button18(
                onClick = { viewModel.reduce(RegistrationAction.OnContinueClick()) },
                textResId = R.string.continue_next
            )
        }
    }
}

//
//@Preview
//@Composable
//fun RegistrationScreenPreview() {
//    RegistrationScreen().SetupContent()
//}