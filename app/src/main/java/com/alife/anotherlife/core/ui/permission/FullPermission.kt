package com.alife.anotherlife.core.ui.permission

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.alife.anotherlife.core.ui.permission.strategy.PermissionStrategy
import com.alife.anotherlife.di.core.IntentModule.Companion.settingsIntent
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

abstract class FullPermission(
    permission: String,
    permissionStrategy: PermissionStrategy,
    failDialog: AbstractDialog,
    private val fatalDialog: AbstractDialog
) : AbstractPermission(permission, permissionStrategy, failDialog) {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun OnAllPermissionSetup(
        permissionState: PermissionState,
        permissionStatus: PermissionStatus,
        onPermission: (PermissionStatus) -> Unit
    ) {
        val context = LocalContext.current

        super.OnAllPermissionSetup(permissionState, permissionStatus, onPermission)

        val activityLauncher = rememberLauncherForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            permissionState.launchPermissionRequest()
        }

        fatalDialog.ShowDialog(
            permissionStatus is PermissionStatus.Fatality,
            onAgree = { activityLauncher.launch(context.settingsIntent()) },
            onDismiss = { onPermission(PermissionStatus.Fatal()) }
        )
    }
}