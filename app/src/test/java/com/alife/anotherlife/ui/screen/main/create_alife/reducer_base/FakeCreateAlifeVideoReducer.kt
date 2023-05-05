package com.alife.anotherlife.ui.screen.main.create_alife.reducer_base

import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.BaseCreateAlifeVideoReducer
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

class FakeCreateAlifeVideoReducer(
    private val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>
) : BaseCreateAlifeVideoReducer {

    override suspend fun onClickSmallVideo() {
        uiStore.setEffect(FakeCreateAlifeEffect.Video.ClickSmallVideo())
    }

    override suspend fun onAudioPermission(permissionStatus: PermissionStatus) {
        uiStore.setEffect(FakeCreateAlifeEffect.Video.AudioPermission())
    }

    override suspend fun onPermissionGranted(newScreenState: ScreenState) {
        uiStore.setEffect(FakeCreateAlifeEffect.Video.PermissionGranted())
    }

    override suspend fun onPermissionFatal() {
        uiStore.setEffect(FakeCreateAlifeEffect.Video.PermissionFatal())
    }
}