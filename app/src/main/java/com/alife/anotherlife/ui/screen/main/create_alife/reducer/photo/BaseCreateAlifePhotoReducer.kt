package com.alife.anotherlife.ui.screen.main.create_alife.reducer.photo

import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.picture.CameraPictureScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.BaseCameraPermissionReducer
import java.util.concurrent.Executor

interface BaseCreateAlifePhotoReducer : BaseCameraPermissionReducer {

    suspend fun onCreatePhoto(
        screenState: CameraPictureScreenState,
        mainExecutor: Executor
    )
}