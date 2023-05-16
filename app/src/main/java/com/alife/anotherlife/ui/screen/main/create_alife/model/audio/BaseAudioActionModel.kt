package com.alife.anotherlife.ui.screen.main.create_alife.model.audio

import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus

interface BaseAudioActionModel {

    fun copyAudioModel(audioModel: BaseAudioModel): BaseAudioModel


    class Permission @OptIn(ExperimentalPermissionsApi::class) constructor(
        private val permissionStatus: PermissionStatus
    ) : BaseAudioActionModel {

        @OptIn(ExperimentalPermissionsApi::class)
        override fun copyAudioModel(audioModel: BaseAudioModel): BaseAudioModel {
            return audioModel.copyPermission(permissionStatus is PermissionStatus.Granted)
        }
    }

    class Checked(private val isChecked: Boolean) : BaseAudioActionModel {
        override fun copyAudioModel(audioModel: BaseAudioModel): BaseAudioModel {
            return audioModel.copyChecked(isChecked)
        }
    }

    class Full @OptIn(ExperimentalPermissionsApi::class) constructor(
        private val permissionStatus: PermissionStatus,
        private val isChecked: Boolean
    ) : BaseAudioActionModel {
        @OptIn(ExperimentalPermissionsApi::class)
        override fun copyAudioModel(audioModel: BaseAudioModel): BaseAudioModel {
            val newAudioModel = Permission(permissionStatus).copyAudioModel(audioModel)
            return newAudioModel.copyChecked(isChecked)
        }
    }
}