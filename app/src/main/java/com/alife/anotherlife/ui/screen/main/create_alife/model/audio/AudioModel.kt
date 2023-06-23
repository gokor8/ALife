package com.alife.anotherlife.ui.screen.main.create_alife.model.audio

data class AudioModel(
    private val isPermissionGranted: Boolean = false,
    private val isChecked: Boolean = false
) : BaseAudioModel {

    override fun isChecked() = isPermissionGranted && isChecked

    override fun copyChecked(isChecked: Boolean) = copy(isPermissionGranted, isChecked)

    override fun copyPermission(isPermissionGranted: Boolean) = copy(isPermissionGranted, isChecked)
    override fun copyFull(isChecked: Boolean, isPermissionGranted: Boolean) =
        copy(isPermissionGranted, isChecked)
}