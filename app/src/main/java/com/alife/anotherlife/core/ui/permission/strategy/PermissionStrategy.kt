package com.alife.anotherlife.core.ui.permission.strategy

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberPermissionState

interface PermissionStrategy {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun rememberPermission(permission: String, onPermission: (PermissionStatus) -> Unit): PermissionState


    class GoogleRecommend(private val strategyMapper: BaseStrategyMapper) : PermissionStrategy {

        @ExperimentalPermissionsApi
        @Composable
        override fun rememberPermission(
            permission: String,
            onPermission: (PermissionStatus) -> Unit
        ): PermissionState {
            val context = LocalContext.current

            return rememberPermissionState(permission) { isGranted ->
                Log.d("Permission status ${this.javaClass.simpleName}", "$isGranted")
                val shouldFailShow = (context as? Activity)?.run {
                    shouldShowRequestPermissionRationale(permission)
                }

                onPermission(strategyMapper.map(isGranted, shouldFailShow == true))
            }
        }
    }
}