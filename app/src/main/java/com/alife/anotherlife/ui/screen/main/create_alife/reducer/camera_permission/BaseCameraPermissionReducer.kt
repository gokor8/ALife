package com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission

interface BaseCameraPermissionReducer {

    suspend fun onPermissionGranted()

    suspend fun onPermissionFatal()
}