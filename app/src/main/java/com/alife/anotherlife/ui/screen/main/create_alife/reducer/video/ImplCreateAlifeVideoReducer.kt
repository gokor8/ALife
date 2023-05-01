package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video

import com.alife.anotherlife.core.ui.permission.PermissionStatus

interface ImplCreateAlifeVideoReducer {

    suspend fun onClickSmallVideo()

    suspend fun onAudioPermission(permissionStatus: PermissionStatus)
}