package com.alife.anotherlife.ui.screen.main.create_alife.state

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.dialog.DefaultDialog
import com.alife.anotherlife.core.ui.dialog.DialogButtonStrategy

abstract class AbstractDialogErrorEffect(
    @StringRes private val title: Int,
    @StringRes private val description: Int
) : CreateAlifeEffect {
    @Composable
    fun DialogErrorContent(onAgree: () -> Unit) {
        DefaultDialog(
            title,
            description,
            DialogButtonStrategy.OneButton(R.string.permission_dialog_button_error)
        ).ShowDialog(onAgree = onAgree)
    }
}