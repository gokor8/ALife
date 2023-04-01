package com.alife.anotherlife.core.ui.permission.camera

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.alife.anotherlife.core.ui.dialog.AbstractAlertDialog
import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.alife.anotherlife.core.ui.permission.AbstractPermission
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.di.core.IntentModule
import com.alife.anotherlife.di.ui.core.DialogAnnotation
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.shouldShowRationale
import javax.inject.Inject

class CameraPermission @Inject constructor(
    @IntentModule.IntentAnnotation.Settings
    private val settingsIntent: Intent,
    @DialogAnnotation.Camera
    private val alertDialog: AbstractDialog,
) : AbstractPermission(android.Manifest.permission.CAMERA) {

    @Composable
    override fun OnFail(
        permissionStatus: PermissionStatus,
        onAgree: () -> Unit,
        onPermission: (PermissionStatus) -> Unit
    ) {
        val visibility = remember(permissionStatus) {
            mutableStateOf(permissionStatus is PermissionStatus.Fail)
        }

        AnimatedVisibility(visible = visibility.value) {
            alertDialog.ShowDialog(
                /*context.startActivity(settingsIntent)*/
                onAgree = onAgree,
                onDismiss = {
                    visibility.value = !visibility.value
                    onPermission(PermissionStatus.Fatal())
                }
            )
        }
    }
}