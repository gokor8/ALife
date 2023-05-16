package com.alife.anotherlife.ui.screen.main.create_alife.model.audio

interface BaseAudioModel {

    fun isChecked() : Boolean

    fun copyChecked(isChecked: Boolean): BaseAudioModel
    fun copyPermission(isPermissionGranted: Boolean): BaseAudioModel
    fun copyFull(isChecked: Boolean, isPermissionGranted: Boolean): BaseAudioModel
}