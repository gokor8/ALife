package com.alife.anotherlife.ui.screen.registration

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.HintTextOutlined
import com.alife.anotherlife.core.composable.text.OutlinedTextFieldBase
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.core.composable.text.style.Title22Style
import com.alife.anotherlife.core.composable.view_group.CustomColumn
import com.alife.anotherlife.core.ui.screen.DefaultScreen

class RegistrationScreen : DefaultScreen() {

    @Composable
    override fun Content(modifier: Modifier) = CustomColumn(
        modifier = Modifier.padding(horizontal = 32.dp, vertical = 35.dp)
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
                textResId = R.string.what_is_your_name,
                textAlign = TextAlign.Start,
                style = Title22Style().style(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(bottom = 25.dp))

            HintTextOutlined(
                value = "",
                onValueChange = {},
                placeholderTextRes = R.string.name,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Column {
            TextBase(
                textResId = R.string.horizontal_logo,
                style = Title28Style().style(),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(bottom = 25.dp))

            Button18(
                onClick = { /*TODO*/ },
                textResId = R.string.continue_next
            )
        }
    }
}


@Preview
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen().SetupContent()
}