package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.camera.core.CameraSelector
import com.alife.anotherlife.core.ui.reducer.BaseVMReducer
import com.alife.anotherlife.core.ui.store.UIStore
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.CameraScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ErrorScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.LoadScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state.ScreenState
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import javax.inject.Inject

class CreateAlifeReducer @Inject constructor(
    override val uiStore: UIStore<CreateAlifeState, CreateAlifeEffect>,
) : BaseVMReducer<CreateAlifeState, CreateAlifeEffect>(), BaseCreateAlifeReducer {

    override suspend fun onChangeCamera() {
        setState {
            val currentSelector = (screenState as? CameraScreenState)?.inverseCameraSelector()
                ?: CameraSelector.DEFAULT_FRONT_CAMERA

            copy(screenState = CameraScreenState(currentSelector))
        }
    }

    override suspend fun onPermissionGranted() {
        setState { copy(screenState = CameraScreenState()) }
    }

    override suspend fun onPermissionSelect() {
        setState { copy(screenState = LoadScreenState()) }
    }

    override suspend fun onPermissionFatal() {
        setState { copy(screenState = ErrorScreenState()) }
    }
}