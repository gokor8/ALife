package com.alife.anotherlife.core.ui.permission.camera

import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.alife.anotherlife.core.ui.permission.AbstractPermission
import com.alife.anotherlife.core.ui.permission.strategy.BaseStrategyMapper
import com.alife.anotherlife.core.ui.permission.strategy.PermissionStrategy
import com.alife.anotherlife.di.ui.core.DialogAnnotation
import javax.inject.Inject

class CameraPermission @Inject constructor(
    @DialogAnnotation.Camera
    failDialog: AbstractDialog
) : AbstractPermission(
    android.Manifest.permission.CAMERA,
    PermissionStrategy.GoogleRecommend(BaseStrategyMapper.Default()),
    failDialog
)