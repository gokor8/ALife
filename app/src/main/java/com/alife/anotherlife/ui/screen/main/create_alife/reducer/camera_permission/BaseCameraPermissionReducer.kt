package com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission

import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState

interface BaseCameraPermissionReducer {

    suspend fun onPermissionGranted(newScreenState: ScreenState)

    suspend fun onPermissionFatal()
}