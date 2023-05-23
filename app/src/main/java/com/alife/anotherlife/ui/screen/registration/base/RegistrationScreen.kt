package com.alife.anotherlife.ui.screen.registration.base

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.core.composable.text.style.Title22Style
import com.alife.anotherlife.core.composable.view_group.CustomColumn
import com.alife.anotherlife.core.ui.screen.VMScreen
import com.alife.anotherlife.core.ui.screen.VMScreenLCE
import com.alife.anotherlife.ui.screen.registration.base.model.RegistrationTextModel
import com.alife.anotherlife.ui.screen.registration.base.state.RegistrationAction

abstract class RegistrationScreen<VM : RegistrationViewModel>(
    private val customTextOutlined: RegistrationTextModel = RegistrationTextModel.Default()
) : VMScreenLCE<VM>() {

    override val backHandle = {
        viewModel.reduce(RegistrationAction.OnBackPress())
    }

    override suspend fun onInit() {
        viewModel.reduce(RegistrationAction.OnInit())
    }

    @Composable
    override fun SafeContent(modifier: Modifier) = CustomColumn(
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

            customTextOutlined.TextOutlined(columnScope = this, viewModel = viewModel)
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
                text= R.string.continue_next
            )
        }
    }
}