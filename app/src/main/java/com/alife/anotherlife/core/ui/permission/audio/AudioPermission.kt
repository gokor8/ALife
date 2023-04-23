package com.alife.anotherlife.core.ui.permission.audio

import androidx.compose.runtime.Composable
import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.alife.anotherlife.core.ui.permission.AbstractPermission
import com.alife.anotherlife.core.ui.permission.PermissionStrategy
import com.alife.anotherlife.di.ui.core.DialogAnnotation
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import javax.inject.Inject

class AudioPermission @Inject constructor(
    @DialogAnnotation.Audio
    alertDialog: AbstractDialog,
) : AbstractPermission(
    android.Manifest.permission.RECORD_AUDIO,
    PermissionStrategy.GoogleRecommend(),
    alertDialog
) {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun requirePermission(audioPermissionContract: AudioPermissionContract): PermissionState {
        return requirePermission { audioPermissionContract.audioBoxReduce(it) }
    }
}