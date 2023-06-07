package com.alife.anotherlife.core.composable.text

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HintBasicTextField(
    text: String,
    @StringRes hint: Int,
    color: Color,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
) {
    BasicTextField(
        value = text,
        decorationBox = { innerTextField ->
            if (text.isEmpty())
                TextBase(
                    textResId = hint,
                    color = color.copy(.7f),
                    modifier = modifier.fillMaxWidth()
                )

            innerTextField()
        },
        onValueChange = onValueChange
    )
}