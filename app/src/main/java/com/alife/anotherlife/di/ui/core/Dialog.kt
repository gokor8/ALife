package com.alife.anotherlife.di.ui.core

import com.alife.anotherlife.core.ui.dialog.AbstractDialogWrapper
import com.alife.anotherlife.core.ui.dialog.CameraDialogWrapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Qualifier

@Module
@InstallIn(ViewModelComponent::class)
interface Dialog {

    @DialogAnnotation.Camera
    @Binds
    fun bindCameraDialogWrapper(dialog: CameraDialogWrapper): AbstractDialogWrapper


    interface DialogAnnotation {

        @Qualifier
        @Retention(AnnotationRetention.RUNTIME)
        annotation class Camera
    }
}