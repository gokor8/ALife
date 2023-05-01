package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video

import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission.CameraPermissionReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import javax.inject.Inject

class CreateAlifeVideoReducer @Inject constructor(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>,
) : CameraPermissionReducer(uiStore), BaseCreateAlifeVideoReducer {

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onClickSmallVideo() {
        getStateSuspend {
            setEffect(
                CreateAlifeEffect.VideoToMainPage(
                    pagerState, pagerContainer.adapter.getVideoIndex()
                )
            )
        }
    }

    override suspend fun onAudioPermission(permissionStatus: PermissionStatus) {

    }
}