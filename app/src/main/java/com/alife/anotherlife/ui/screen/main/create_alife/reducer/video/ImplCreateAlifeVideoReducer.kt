package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video

interface ImplCreateAlifeVideoReducer {

    suspend fun onClickSmallVideo()

    suspend fun onAudioPermissionGranted()

    suspend fun onAudioPermissionFatal()
}