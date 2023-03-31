package com.alife.anotherlife.core.ui.dialog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.addons.Line
import com.alife.anotherlife.core.composable.button.DefaultButton
import com.alife.anotherlife.core.composable.button.TextTransparentButton
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Default16TextStyle
import com.alife.anotherlife.core.composable.text.style.Title18Style
import com.alife.anotherlife.core.ui.text.TextWrapper

abstract class AbstractDialogWrapper(
    @DrawableRes private val icon: Int,
    private val title: TextWrapper,
    private val description: TextWrapper
) {

    @Composable
    fun ShowDialog(
        onAgree: () -> Unit,
        onDismiss: () -> Unit
    ) {
        Dialog(onDismissRequest = onDismiss) {
            Column(Modifier.padding(16.dp)) {
                IconBase(icon = icon)
                Spacer(modifier = Modifier.padding(bottom = 18.dp))

                TextBase(textWrapper = title, style = Title18Style().style())

                Line(modifier = Modifier.padding(vertical = 10.dp))

                TextBase(textWrapper = description, style = Default16TextStyle().style())

                Row {
                    TextTransparentButton(
                        textResId = R.string.cancel,
                        contentPadding = PaddingValues(12.dp),
                        onClick = onDismiss
                    )
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    DefaultButton(textResId = R.string.agree, onClick = onAgree)
                }
            }
        }
    }
}