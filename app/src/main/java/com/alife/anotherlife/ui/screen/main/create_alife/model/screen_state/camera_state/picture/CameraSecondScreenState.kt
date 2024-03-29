package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture

import androidx.camera.core.CameraSelector
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo.BaseCreateAlifePhotoReducer

class CameraSecondScreenState(
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
) : CameraPictureScreenState(cameraSelector) {

    override suspend fun onImageLoaded(
        reducer: BaseCreateAlifePhotoReducer,
        captureWrapper: CookedCaptureWrapper
    ) {
        reducer.onFinish(captureWrapper)
    }
}