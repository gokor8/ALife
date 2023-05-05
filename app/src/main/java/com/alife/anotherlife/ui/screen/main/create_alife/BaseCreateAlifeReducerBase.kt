package com.alife.anotherlife.ui.screen.main.create_alife

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.ImplCreateAlifePhotoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.ImplCreateAlifeVideoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

interface BaseCreateAlifeReducerBase : BaseVMReducer<CreateAlifeState, CreateAlifeEffect>,
    ImplCreateAlifePhotoReducer, ImplCreateAlifeVideoReducer {

    suspend fun onChangeCamera()

    suspend fun onCameraWrapper(captureWrapper: BaseCaptureWrapper)

    suspend fun onPicturePermission(photoPermission: CreateAlifeAction.PhotoPermission)
    suspend fun onVideoPermission(videoPermission: CreateAlifeAction.VideoPermission)
    @OptIn(ExperimentalPermissionsApi::class)
    suspend fun onVideoAudioPermission(audio: PermissionState)
}