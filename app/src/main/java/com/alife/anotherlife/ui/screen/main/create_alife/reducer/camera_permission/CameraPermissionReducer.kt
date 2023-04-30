package com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission

import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.reducer.HandlerVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ErrorScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.camera_state.ScreenFirstScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import javax.inject.Inject

abstract class CameraPermissionReducer@Inject constructor(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>
): HandlerVMReducer<CreateAlifeState, CreateAlifeEffect>(), BaseCameraPermissionReducer {

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onPermissionGranted() {
        setState { copy(screenState = ScreenFirstScreenState()) }
    }

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onPermissionFatal() {
        // TODO go to main menu
        setState { copy(screenState = ErrorScreenState()) }
    }
}