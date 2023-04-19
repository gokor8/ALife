package com.alife.anotherlife.ui.screen.main.create_alife

import android.content.ContextWrapper
import com.alife.anotherlife.core.ui.reducer.VMReducer
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.CameraPagerItem
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

interface BaseCreateAlifeReducer : VMReducer<CreateAlifeState, CreateAlifeEffect> {

    suspend fun onChangeCamera()

    suspend fun onCameraWrapper(captureWrapper: BaseCaptureWrapper)

    suspend fun onStartTakePhoto(pagerItem: CameraPagerItem)
    suspend fun onTakePhoto(imageByteArray: ByteArray)
    suspend fun onCreatePhoto(contextWrapper: ContextWrapper)

    suspend fun onPermissionGranted()
    suspend fun onPermissionFatal()
}