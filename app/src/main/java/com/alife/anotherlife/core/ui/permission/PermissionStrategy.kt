package com.alife.anotherlife.core.ui.permission

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberPermissionState

interface PermissionStrategy {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun rememberPermission(permission: String, onPermission: (PermissionStatus) -> Unit): PermissionState


    class GoogleRecommend : PermissionStrategy {

        @ExperimentalPermissionsApi
        @Composable
        override fun rememberPermission(
            permission: String,
            onPermission: (PermissionStatus) -> Unit
        ): PermissionState {
            val context = LocalContext.current

            return rememberPermissionState(permission) { isGranted ->
                Log.d("Permission status ${this.javaClass.simpleName}", "$isGranted")
                val activity = context as? Activity

                val permissionStatus = when {
                    isGranted -> PermissionStatus.Success()
                    activity?.shouldShowRequestPermissionRationale(permission) == true -> {
                        PermissionStatus.Fail()
                    }
                    else -> PermissionStatus.Fatal()
                }

                onPermission(permissionStatus)
            }
        }
    }
}