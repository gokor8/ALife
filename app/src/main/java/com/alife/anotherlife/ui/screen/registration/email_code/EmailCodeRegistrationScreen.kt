package com.alife.anotherlife.ui.screen.registration.email_code

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.code.CodeTextOutlined
import com.alife.anotherlife.core.composable.text.style.Title22Style
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.composable.view_group.CustomColumn
import com.alife.anotherlife.core.ui.screen.VMScreen
import javax.inject.Inject

class EmailCodeRegistrationScreen @Inject constructor(
    override val navController: NavController,
) : VMScreen<EmailCodeRegistrationVM>() {

    @Composable
    override fun setupViewModel(): EmailCodeRegistrationVM = hiltViewModel()

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
                textResId = R.string.email_code,
                textAlign = TextAlign.Center,
                style = Title22Style().style(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(bottom = 25.dp))

            CodeTextOutlined(
                codeModel = viewModel.getUIState().codeModel,
                codeViewModel = viewModel,
                contentPaddingValues = PaddingValues(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.padding(bottom = 8.dp))
            TextBase(viewModel.getUIState().error, color = MaterialTheme.colorScheme.error)
            Spacer(modifier = Modifier.padding(bottom = 25.dp))
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            TextBase(
                textResId = R.string.horizontal_logo,
                style = Title28Style().style(),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(bottom = 25.dp))
        }
    }
}

@Preview
@Composable
fun EmailCodeRegistrationScreenPreview() {
    EmailCodeRegistrationScreen(rememberNavController()).SetupContent()
}