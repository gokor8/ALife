package com.alife.anotherlife.ui.screen.main.create_alife.model.audio

import com.alife.anotherlife.core.ui.permission.PermissionStatus

interface BaseAudioActionModel {

    fun copyAudioModel(audioModel: BaseAudioModel): BaseAudioModel

    class Permission(
        private val permissionStatus: PermissionStatus
    ) : BaseAudioActionModel {

        override fun copyAudioModel(audioModel: BaseAudioModel): BaseAudioModel {
            return audioModel.copyPermission(permissionStatus is PermissionStatus.Success)
        }
    }

    class Checked(private val isChecked: Boolean) : BaseAudioActionModel {
        override fun copyAudioModel(audioModel: BaseAudioModel): BaseAudioModel {
            return audioModel.copyChecked(isChecked)
        }
    }
}