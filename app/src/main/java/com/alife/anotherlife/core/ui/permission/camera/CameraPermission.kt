package com.alife.anotherlife.core.ui.permission.camera

import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.alife.anotherlife.core.ui.permission.AbstractPermission
import com.alife.anotherlife.core.ui.permission.MomentaryPermission
import com.alife.anotherlife.core.ui.permission.PermissionStrategy
import com.alife.anotherlife.di.ui.core.DialogAnnotation
import javax.inject.Inject

class CameraPermission @Inject constructor(
    @DialogAnnotation.Camera
    alertDialog: AbstractDialog,
) : MomentaryPermission(
    android.Manifest.permission.CAMERA,
    PermissionStrategy.GoogleRecommend(),
    alertDialog
)