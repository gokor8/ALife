package com.alife.anotherlife.di.ui.core

import com.alife.anotherlife.core.ui.permission.BasePermission
import com.alife.anotherlife.core.ui.permission.camera.MomentaryCameraPermission
import com.alife.anotherlife.core.ui.permission.location.MomentaryLocationPermission
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface Permission {

    @Binds
    fun bindCameraPermission(permission: MomentaryCameraPermission): BasePermission

    //@Binds
    //fun bindMomentaryLocationPermission(permission: MomentaryLocationPermission): BasePermission
}