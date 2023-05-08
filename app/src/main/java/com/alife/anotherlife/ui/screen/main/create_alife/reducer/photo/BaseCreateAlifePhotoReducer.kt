package com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo

import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BaseInvertPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BasePictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.PictureLoadedScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.BaseCameraPermissionReducer

interface BaseCreateAlifePhotoReducer : BaseCameraPermissionReducer<BasePictureScreenState> {

    fun onCaptureWrapper(captureWrapper: CookedCaptureWrapper)

    suspend fun onCreatePhoto(
        screenState: PictureLoadedScreenState,
        captureWrapper: CookedCaptureWrapper,
        contextWrapper: BaseContextMainExecutorWrapper
    )
}