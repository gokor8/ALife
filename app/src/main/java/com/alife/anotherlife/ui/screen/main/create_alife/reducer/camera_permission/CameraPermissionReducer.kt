package com.alife.anotherlife.ui.screen.main.create_alife.reducer.camera_permission

import androidx.compose.foundation.ExperimentalFoundationApi
import com.alife.anotherlife.core.ui.reducer.HandlerBaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.model.pager_item.container.ScreenPagerContainer
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState

abstract class CameraPermissionReducer<S : ScreenState>(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>
) : HandlerBaseVMReducer<CreateAlifeState, CreateAlifeEffect>(), BaseCameraPermissionReducer<S> {

    abstract fun changeCurrentScreen(screenState: S): ScreenPagerContainer

    @OptIn(ExperimentalFoundationApi::class)
    override suspend fun onPermissionGranted(screenState: S) {
        setState { copy(pagerContainer = changeCurrentScreen(screenState)) }
    }

    override suspend fun onPermissionFatal() {
        setEffect(CreateAlifeEffect.GoBack())
    }
}