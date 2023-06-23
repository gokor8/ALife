package com.alife.anotherlife.ui.screen.main.create_alife.model.audio

import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.google.accompanist.permissions.ExperimentalPermissionsApi

interface BaseAudioActionModel {

    fun copyAudioModel(audioModel: BaseAudioModel): BaseAudioModel

    class Permission(
        private val permissionStatus: PermissionStatus
    ) : BaseAudioActionModel {

        override fun copyAudioModel(audioModel: BaseAudioModel): BaseAudioModel {
            return audioModel.copyPermission(permissionStatus is PermissionStatus.Success)
        }
    }

//    class PermissionStatus @OptIn(ExperimentalPermissionsApi::class) constructor(
//        private val permissionStatus: com.google.accompanist.permissions.PermissionStatus
//    ) : BaseAudioActionModel {
//
//        @OptIn(ExperimentalPermissionsApi::class)
//        override fun copyAudioModel(audioModel: BaseAudioModel): BaseAudioModel {
//            return audioModel.copyPermission(permissionStatus is com.google.accompanist.permissions.PermissionStatus.Granted)
//        }
//    }

    class Checked(private val isChecked: Boolean) : BaseAudioActionModel {
        override fun copyAudioModel(audioModel: BaseAudioModel): BaseAudioModel {
            return audioModel.copyChecked(isChecked)
        }
    }
}