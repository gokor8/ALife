package com.alife.anotherlife.core.ui.permission

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.alife.anotherlife.core.ui.dialog.AbstractDialogWrapper
import com.alife.anotherlife.di.core.IntentModule
import com.alife.anotherlife.di.ui.core.Dialog

class CameraPermission(
    @IntentModule.IntentAnnotation.Settings
    private val settingsIntent: Intent,
    @Dialog.DialogAnnotation.Camera
    private val abstractDialogWrapper: AbstractDialogWrapper
) : AbstractPermission(android.Manifest.permission.CAMERA) {

    @Composable
    override fun OnFatal() {
        val visibility = remember { mutableStateOf(false) }

        AnimatedVisibility(visible = visibility.value) {
            val context = LocalContext.current

            abstractDialogWrapper.ShowDialog(
                onAgree = {
                    context.startActivity(settingsIntent)
                    Intent().apply {
                        action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                        data = Uri.fromParts("package", context.packageName, null)
                    }
                },
                onDismiss = { visibility.value = !visibility.value }
            )
        }
    }
}