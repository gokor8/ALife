package com.alife.anotherlife.core.ui.permission.audio

import androidx.compose.runtime.Composable
import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.alife.anotherlife.core.ui.permission.AbstractPermission
import com.alife.anotherlife.core.ui.permission.FullAbstractPermission
import com.alife.anotherlife.core.ui.permission.strategy.BaseStrategyMapper
import com.alife.anotherlife.core.ui.permission.strategy.PermissionStrategy
import com.alife.anotherlife.di.ui.core.DialogAnnotation
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import javax.inject.Inject

class AudioPermission @Inject constructor(
    @DialogAnnotation.Audio
    failDialog: AbstractDialog
) : AbstractPermission(
    android.Manifest.permission.RECORD_AUDIO,
    PermissionStrategy.GoogleRecommend(BaseStrategyMapper.Default()),
    failDialog
) {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun requirePermission(audioPermissionContract: AudioPermissionContract): PermissionState {
        return requirePermission { audioPermissionContract.audioBoxReduce(it) }
    }
}