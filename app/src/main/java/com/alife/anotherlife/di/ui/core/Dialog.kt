package com.alife.anotherlife.di.ui.core

import com.alife.anotherlife.core.ui.dialog.AbstractDialog
import com.alife.anotherlife.core.ui.dialog.SettingsDialog
import com.alife.anotherlife.core.ui.dialog.audio.AudioDialog
import com.alife.anotherlife.core.ui.dialog.camera.CameraDialog
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface Dialog {

    @Binds
    @DialogAnnotation.SettingsAudio
    fun bindSettingsAudioDialog(dialog: SettingsDialog.Audio): AbstractDialog

    @Binds
    @DialogAnnotation.Audio
    fun bindAudioDialog(dialog: AudioDialog): AbstractDialog

    @Binds
    @DialogAnnotation.Camera
    fun bindCameraDialogWrapper(dialog: CameraDialog): AbstractDialog
}