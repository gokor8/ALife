package com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission

import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import com.google.accompanist.permissions.ExperimentalPermissionsApi

abstract class CameraPermissionReducerBase(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>
) : HandlerBaseVMReducer<CreateAlifeState, CreateAlifeEffect>(), BaseCameraPermissionReducer {

    @OptIn(ExperimentalFoundationApi::class, ExperimentalPermissionsApi::class)
    override suspend fun onPermissionGranted(newScreenState: ScreenState) {
        setState { copy(pagerContainer = changeCurrentScreen(newScreenState)) }
    }

    override suspend fun onPermissionFatal() {
        setEffect(CreateAlifeEffect.GoBack())
    }
}