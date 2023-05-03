package com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission

import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

abstract class CameraPermissionReducerBase(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>
) : HandlerBaseVMReducer<CreateAlifeState, CreateAlifeEffect>(), BaseCameraPermissionReducer {

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onPermissionGranted() {
        setState { copy(pagerContainer = changeCurrentScreen(getPermissionGrantedScreen())) }
    }

    override suspend fun onPermissionFatal() {
        setEffect(CreateAlifeEffect.GoBack())
    }

    protected abstract fun getPermissionGrantedScreen(): ScreenState
}