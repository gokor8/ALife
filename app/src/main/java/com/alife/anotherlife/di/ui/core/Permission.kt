package com.alife.anotherlife.di.ui.core

import com.alife.anotherlife.core.ui.permission.BasePermission
import com.alife.anotherlife.core.ui.permission.CameraPermission
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface Permission {

    fun bindCameraPermission(permission: CameraPermission): BasePermission
}