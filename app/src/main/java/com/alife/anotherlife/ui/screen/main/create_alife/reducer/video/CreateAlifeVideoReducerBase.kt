package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video

import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.video.CameraVideoScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.CameraPermissionReducerBase
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import javax.inject.Inject

class CreateAlifeVideoReducerBase @Inject constructor(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>,
) : CameraPermissionReducerBase(uiStore), BaseCreateAlifeVideoReducer {

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onClickSmallVideo() {
        setEffect(
            CreateAlifeEffect.VideoToMainPage(
                getState().pagerState,
                getState().pagerContainer.getVideoIndex()
            )
        )
    }

    @OptIn(ExperimentalPermissionsApi::class)
    override suspend fun onVideoAudioGranted(audio: PermissionState) {
        setEffect(CreateAlifeEffect.RequestAudioPermission(audio))
    }

    override suspend fun onAudioPermission(permissionStatus: PermissionStatus) {

    }
}