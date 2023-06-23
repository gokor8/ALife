package com.alife.anotherlife.core.ui.state.lce

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.addons.IconInCircle
import com.alife.anotherlife.core.composable.modifier.SystemPaddingModifier
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.core.composable.text.style.Title18Style
import com.alife.anotherlife.core.composable.text.style.Title20Style
import com.alife.anotherlife.core.ui.text.TextWrapper

interface EmptyError: LCEModel.Error {
    @Composable
    override fun LCEContent(modifier: Modifier) = Unit
}

class LCEError(
    private val title: TextWrapper,
    private val description: TextWrapper,
    private val buttonText: TextWrapper,
    private val onTry: () -> Unit
) : LCEModel.Error {

    @Composable
    override fun LCEContent(modifier: Modifier) {
        ErrorScreen(title.getString(), description.getString(), buttonText.getString(), Modifier, onTry)
    }
}

@Composable
fun ErrorScreen(
    title: String,
    description: String = "",
    expandContent: @Composable () -> Unit = {}
) = Column(
    modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .then(SystemPaddingModifier.provideModifier())
        .padding(horizontal = 40.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
) {
    IconInCircle(
        icon = R.drawable.ic_base_error,
        tint = MaterialTheme.colorScheme.onError,
        circleTint = MaterialTheme.colorScheme.error,
        iconPaddingValues = PaddingValues(12.dp)
    )
    Spacer(modifier = Modifier.padding(bottom = 40.dp))

    Text(
        text = title,
        style = Title20Style(color = MaterialTheme.colorScheme.onBackground).style(),
        textAlign = TextAlign.Center
    )

    Divider(modifier = Modifier.padding(vertical = 20.dp))

    if (description.isNotEmpty()) {
        Text(
            text = description,
            style = Title18Style(color = MaterialTheme.colorScheme.onBackground).style(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
    }

    expandContent()
}

@Composable
fun ErrorScreen(
    title: String,
    description: String = "",
    buttonText: String = "",
    modifier: Modifier = Modifier,
    onTry: () -> Unit = {}
) = Column(
    modifier = modifier
        .background(MaterialTheme.colorScheme.background)
        .then(SystemPaddingModifier.provideModifier()),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
) {
    ErrorScreen(title, description) {
        if (buttonText.isNotEmpty())
            Button18(text = buttonText, onClick = onTry, modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
fun ErrorScreenPreview() {
    ErrorScreen("Test", "Test test test", "Test") {}
}