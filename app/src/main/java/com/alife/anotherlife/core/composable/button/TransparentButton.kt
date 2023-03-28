package com.alife.anotherlife.core.composable.button

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.theme.Shapes

@Composable
fun TextTransparentButton(
    @StringRes textResId: Int,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = null,
    shape: Shape = Shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent,
        contentColor = LocalContentColor.current,
        disabledContainerColor = Color.Transparent,
        disabledContentColor = LocalContentColor.current.copy(0.5f)
    ),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        elevation = elevation,
        colors = colors,
        enabled = enabled,
        interactionSource = interactionSource,
        shape = shape,
        border = border,
        contentPadding = contentPadding,
        modifier = modifier,
    ) {
        TextBase(textResId = textResId, style = textStyle)
    }
}

@Composable
fun TransparentButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = null,
    shape: Shape = Shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
    ),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        elevation = elevation,
        colors = colors,
        enabled = enabled,
        interactionSource = interactionSource,
        shape = shape,
        border = border,
        contentPadding = contentPadding,
        modifier = modifier,
        content = content
    )
}