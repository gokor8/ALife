package com.alife.anotherlife.core.composable.button

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.core.composable.text.style.Bold16TextStyle

@Composable
fun TransparentStrokeButton(
    @StringRes textResId: Int,
    onClick: () -> Unit
) {
    TextTransparentButton(
        textResId = textResId,
        textStyle = Bold16TextStyle().style(),
        border = BorderStroke(1.dp, Color.Black),
        contentPadding = PaddingValues(vertical = 12.dp),
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    )
}