package com.alife.anotherlife.core.ui.permission

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.*

abstract class AbstractPermission(
    private val permission: String,
) : BasePermission {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun requirePermission(onPermission: (PermissionStatus) -> Unit): PermissionState {
        val context = LocalContext.current

        var permissionStatus by remember {
            mutableStateOf<PermissionStatus>(PermissionStatus.Init())
        }

        val rememberPermission = rememberPermissionState(permission) { isGranted ->
            Log.d("Permission status ${this.javaClass.simpleName}", "$isGranted")
            val activity = context as? Activity

            permissionStatus = when {
                isGranted -> PermissionStatus.Success()
                activity?.shouldShowRequestPermissionRationale(permission) == true -> {
                    PermissionStatus.Fail()
                }
                else -> PermissionStatus.Fatal()
            }

            onPermission(permissionStatus)
        }

        LaunchedEffect(Unit) { rememberPermission.launchPermissionRequest() }

        OnFail(
            permissionStatus = permissionStatus,
            onAgree = { rememberPermission.launchPermissionRequest() },
            onPermission = onPermission
        )

        return rememberPermission
    }

    @Composable
    protected abstract fun OnFail(
        permissionStatus: PermissionStatus,
        onAgree: () -> Unit,
        onPermission: (PermissionStatus) -> Unit,
    )
}