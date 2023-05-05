package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video

import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.BaseCameraPermissionReducer
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

interface BaseCreateAlifeVideoReducer : ImplCreateAlifeVideoReducer, BaseCameraPermissionReducer