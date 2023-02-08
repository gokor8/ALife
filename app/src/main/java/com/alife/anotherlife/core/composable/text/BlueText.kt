package com.example.testnavigation.screens.core.compose_bases.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.testnavigation.screens.core.styles.text_style.ButtonTextStyle

@Composable
fun BlueText(textResId: Int, modifier: Modifier = Modifier, textAlign: TextAlign = TextAlign.Center) {
    TextBase(
        textResId,
        style = ButtonTextStyle(),
        textAlign = textAlign,
        modifier = modifier
    )
}