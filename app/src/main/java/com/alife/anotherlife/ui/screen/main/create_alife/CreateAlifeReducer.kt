package com.alife.anotherlife.ui.screen.main.create_alife

import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import javax.inject.Inject

class CreateAlifeReducer @Inject constructor(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>
) : BaseVMReducer<CreateAlifeState, CreateAlifeEffect>(), BaseCreateAlifeReducer {
    override suspend fun onPermissionGranted() {
        setState { copy(screenState = ScreenState.Camera()) }
    }

    override suspend fun onPermissionSelect() {
        setState { copy(screenState = ScreenState.Load()) }
    }

    override suspend fun onPermissionFatal() {
        setState { copy(screenState = ScreenState.Error()) }
    }
}