package com.alife.anotherlife.ui.screen.main.main_screen.navigation_bar.home.pager_screens.base_pager_screen.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.button.TextTransparentButton
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Bold16TextStyle
import com.alife.anotherlife.core.composable.text.style.Default16TextStyle

@Composable
fun PlzCreateAlifeCompose(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        TextBase(
            textResId = R.string.home_friends_be_first,
            style = Default16TextStyle().style(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))

        TextTransparentButton(
            textResId = R.string.home_friends_create_alife,
            textStyle = Bold16TextStyle().style(),
            border = BorderStroke(1.dp, Color.Black),
            contentPadding = PaddingValues(vertical = 12.dp),
            onClick = onClick,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PlzCreateAlifeComposePreview() {
    PlzCreateAlifeCompose {}
}