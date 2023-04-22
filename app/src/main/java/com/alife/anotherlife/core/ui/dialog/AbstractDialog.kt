package com.alife.anotherlife.core.ui.dialog

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.addons.Line
import com.alife.anotherlife.core.composable.button.DefaultButton
import com.alife.anotherlife.core.composable.button.TextTransparentButton
import com.alife.anotherlife.core.composable.icon.IconBase
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Default16TextStyle
import com.alife.anotherlife.core.composable.text.style.Title18Style
import com.alife.anotherlife.core.ui.text.TextWrapper
import com.alife.anotherlife.theme.Shapes

abstract class AbstractDialog(
    @DrawableRes private val icon: Int,
    private val title: TextWrapper,
    private val description: TextWrapper,
) {

    @Composable
    fun ShowDialog(
        isVisible: Boolean = true,
        onAgree: () -> Unit,
        onDismiss: () -> Unit,
    ) {
        var visibility by remember(isVisible) { mutableStateOf(isVisible) }

        val wrappedDismiss = {
            visibility = !visibility
            onDismiss()
        }

        if (visibility) {
            Dialog(onDismissRequest = wrappedDismiss) {
                Surface(modifier = Modifier.clip(Shapes.large)) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        IconBase(icon = icon)
                        Spacer(modifier = Modifier.padding(bottom = 18.dp))

                        TextBase(
                            textWrapper = title,
                            style = Title18Style().style(),
                            textAlign = TextAlign.Center
                        )

                        Line(strokeWidth = 20f, modifier = Modifier.padding(vertical = 10.dp))

                        TextBase(
                            textWrapper = description,
                            style = Default16TextStyle().style(),
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.padding(bottom = 32.dp))

                        Row(modifier = Modifier.fillMaxWidth()) {
                            TextTransparentButton(
                                textResId = R.string.cancel,
                                contentPadding = PaddingValues(12.dp),
                                onClick = wrappedDismiss
                            )
                            Spacer(modifier = Modifier.padding(start = 8.dp))
                            DefaultButton(
                                textResId = R.string.agree,
                                onClick = onAgree,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}