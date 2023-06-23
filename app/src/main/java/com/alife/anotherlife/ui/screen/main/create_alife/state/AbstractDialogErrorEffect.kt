package com.alife.anotherlife.ui.screen.main.create_alife.state

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.dialog.DefaultDialog
import com.alife.anotherlife.core.ui.dialog.DialogButtonStrategy

@Stable
interface BaseDialogErrorEffect : CreateAlifeEffect {
    @Composable
    fun DialogErrorContent(onAgree: () -> Unit) = Unit
}

@Stable
abstract class AbstractDialogErrorEffect(
    @StringRes private val title: Int,
    @StringRes private val description: Int
) : BaseDialogErrorEffect {

    @Composable
    override fun DialogErrorContent(onAgree: () -> Unit) {
        DefaultDialog(
            title,
            description,
            DialogButtonStrategy.OneButton(R.string.permission_dialog_settings)
        ).ShowDialog(onAgree = onAgree)
    }
}