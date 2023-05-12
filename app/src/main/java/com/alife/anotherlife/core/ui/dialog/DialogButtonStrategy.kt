package com.alife.anotherlife.core.ui.dialog

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.button.BorderButton
import com.alife.anotherlife.core.composable.button.DefaultButton
import com.alife.anotherlife.core.composable.button.TextTransparentButton

interface DialogButtonStrategy {

    @Composable
    fun ButtonsContent(
        onAgree: () -> Unit,
        onDismiss: () -> Unit
    )


    class ShouldPermission : DialogButtonStrategy {

        @Composable
        override fun ButtonsContent(
            onAgree: () -> Unit,
            onDismiss: () -> Unit
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.padding(bottom = 32.dp))

                TextTransparentButton(
                    textResId = R.string.cancel,
                    contentPadding = PaddingValues(12.dp),
                    onClick = onDismiss
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

    class OneButton(@StringRes private val text: Int) : DialogButtonStrategy {

        @Composable
        override fun ButtonsContent(
            onAgree: () -> Unit,
            onDismiss: () -> Unit
        ) {
            Spacer(modifier = Modifier.padding(bottom = 22.dp))
            BorderButton(text, onClick = onAgree)
        }
    }

    class Empty : DialogButtonStrategy {
        @Composable
        override fun ButtonsContent(onAgree: () -> Unit, onDismiss: () -> Unit) {}
    }
}