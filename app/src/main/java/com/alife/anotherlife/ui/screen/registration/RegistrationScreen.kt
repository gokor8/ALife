package com.alife.anotherlife.ui.screen.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.BigTitleStyle
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.core.composable.view_group.CustomColumn
import com.alife.anotherlife.core.ui.screen.DefaultScreen

class RegistrationScreen : DefaultScreen() {

    @Composable
    override fun Content(modifier: Modifier) = CustomColumn {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextBase(textResId = R.string.what_is_your_name)
        }

        Column {
            TextBase(textResId = R.string.horizontal_logo, style = BigTitleStyle().style())
            Spacer(modifier = Modifier.padding(end = 25.dp))

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