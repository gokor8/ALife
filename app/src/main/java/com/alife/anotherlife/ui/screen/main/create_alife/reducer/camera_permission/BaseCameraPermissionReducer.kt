package com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission

import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState

interface BaseCameraPermissionReducer<S : ScreenState> {

    suspend fun onPermissionGranted(screenState: S)

    suspend fun onPermissionFatal()
}