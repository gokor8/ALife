package com.alife.anotherlife.ui.screen.main.create_alife.state

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.alife.anotherlife.core.ui.dialog.DefaultDialog

abstract class AbstractDialogErrorEffect(
    @StringRes private val title: Int,
    @StringRes private val description: Int
) : CreateAlifeEffect {
    @Composable
    fun DialogErrorContent() {
        DefaultDialog(
            title,//R.string.camera_snackbar_camera_title_error,
            description,//R.string.camera_snackbar_camera_description_error
        ).ShowDialog {}
    }
}