package com.alife.anotherlife.ui.screen.main.create_alife

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.ImplCreateAlifePhotoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.ImplCreateAlifeVideoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

interface BaseCreateAlifeReducerBase : BaseVMReducer<CreateAlifeState, CreateAlifeEffect>,
    ImplCreateAlifePhotoReducer, ImplCreateAlifeVideoReducer {

    suspend fun onChangeCamera()

    suspend fun onCameraWrapper(captureWrapper: BaseCaptureWrapper)

    suspend fun onPictureCameraPermission(photoPermission: CreateAlifeAction.PhotoPermission)
    suspend fun onVideoCameraPermission(videoPermission: CreateAlifeAction.VideoPermission)
}