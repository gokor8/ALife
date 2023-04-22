package com.alife.anotherlife.core.ui.permission.audio

import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.alife.anotherlife.core.ui.permission.AbstractPermission
import com.alife.anotherlife.core.ui.permission.PermissionStrategy
import com.alife.anotherlife.di.ui.core.DialogAnnotation
import javax.inject.Inject

class AudioPermission @Inject constructor(
    @DialogAnnotation.Audio
    alertDialog: AbstractDialog,
) : AbstractPermission(
    android.Manifest.permission.CAPTURE_AUDIO_OUTPUT,
    PermissionStrategy.GoogleRecommend(),
    alertDialog
)