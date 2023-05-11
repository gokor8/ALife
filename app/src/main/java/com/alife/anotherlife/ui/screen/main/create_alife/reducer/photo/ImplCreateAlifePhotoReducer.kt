package com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo

import com.alife.anotherlife.ui.screen.main.create_alife.addons.BaseContextMainExecutorWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.CookedCaptureWrapper
import kotlinx.coroutines.CoroutineScope

interface ImplCreateAlifePhotoReducer {

    suspend fun onCreatePhoto(
        viewModelScope: CoroutineScope,
        contextWrapper: BaseContextMainExecutorWrapper,
        captureWrapper: CookedCaptureWrapper
    )
}