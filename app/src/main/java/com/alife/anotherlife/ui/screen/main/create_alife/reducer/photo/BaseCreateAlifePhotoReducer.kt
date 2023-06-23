package com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.BasePictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.PictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.BaseCameraPermissionReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import kotlinx.coroutines.CoroutineScope

interface BaseCreateAlifePhotoReducer : BaseVMReducer<CreateAlifeState, CreateAlifeEffect>,
    BaseCameraPermissionReducer<BasePictureScreenState> {

    fun onCaptureWrapper(captureWrapper: CookedCaptureWrapper)

    suspend fun onCreatePhoto(
        viewModelScope: CoroutineScope,
        screenState: PictureScreenState,
        captureWrapper: CookedCaptureWrapper,
        contextWrapper: BaseContextMainExecutorWrapper
    )

    suspend fun onPictureLoading()

    suspend fun onFinish(captureWrapper: CookedCaptureWrapper)
}