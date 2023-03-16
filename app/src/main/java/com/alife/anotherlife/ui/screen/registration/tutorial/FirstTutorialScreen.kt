package com.alife.anotherlife.ui.screen.registration.tutorial

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.alife_card.ALifeCardCompose
import com.alife.anotherlife.core.composable.button.ButtonBase
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Button18
import com.alife.anotherlife.core.composable.text.style.Title22Style
import com.alife.anotherlife.core.composable.text.style.Title28Style
import com.alife.anotherlife.core.ui.screen.DefaultScreen

class FirstTutorialScreen : DefaultScreen() {

    @Composable
    override fun Content(modifier: Modifier) = Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        TextBase(textResId = R.string.horizontal_short_logo, style = Title28Style().style())

        ALifeCardCompose(modifier = Modifier.padding(horizontal = 44.dp, vertical = 28.dp))

        TextBase(
            textResId = R.string.tutorial_first_description,
            style = Title22Style().style(),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 35.dp)
        )
        Spacer(modifier = Modifier.padding(bottom = 50.dp))

        // TabBar menu

        Button18(
            textResId = R.string.continue_next,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) { }
    }
}

@Preview
@Composable
fun FirstTutorialScreenPreview() {
    FirstTutorialScreen().SetupContent()
}