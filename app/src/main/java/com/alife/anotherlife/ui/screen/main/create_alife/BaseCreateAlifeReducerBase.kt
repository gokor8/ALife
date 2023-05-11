package com.alife.anotherlife.ui.screen.main.create_alife

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.state.BaseStartVideoCaptureState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BasePictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.BaseVideoScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.ImplCreateAlifePhotoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.ImplCreateAlifeVideoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

interface BaseCreateAlifeReducerBase : BaseVMReducer<CreateAlifeState, CreateAlifeEffect>,
    ImplCreateAlifePhotoReducer, ImplCreateAlifeVideoReducer {

    suspend fun onChangeCamera()

    fun onChangedAudio(isEnabled: Boolean)

    suspend fun onCameraWrapper(captureWrapper: BaseCaptureWrapper)

    suspend fun onVideoWrapper(captureWrapper: BaseVideoCaptureWrapper)

    suspend fun onStartVideo(
        contextMainExecutorWrapper: BaseContextMainExecutorWrapper,
        videoCapture: BaseStartVideoCaptureState
    )

    suspend fun onPicturePermission(
        photoPermission: CreateAlifeAction.PhotoPermission,
        screenState: BasePictureScreenState
    )
    suspend fun onVideoPermission(
        videoPermission: CreateAlifeAction.VideoPermission,
        screenState: BaseVideoScreenState
    )
}