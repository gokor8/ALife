package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.permission.audio.AudioPermission
import com.alife.anotherlife.core.ui.permission.audio.AudioPermissionContract
import com.alife.anotherlife.core.ui.permission.camera.CameraPermission
import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.BaseActionScopedMapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.BaseCameraSetupFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateAlifeViewModel @Inject constructor(
    reducer: BaseCreateAlifeReducerBase,
    private val actionMapper: BaseActionScopedMapper,
    val cameraPermission: CameraPermission,
    val audioPermission: AudioPermission,
    val imageSetupFactory: BaseCameraSetupFactory<BaseCaptureWrapper>,
    val videoSetupFactory: BaseCameraSetupFactory<BaseVideoCaptureWrapper>
) : ViewModelLCE<BaseCreateAlifeReducerBase, CreateAlifeAction, CreateAlifeState, CreateAlifeEffect>(
    reducer
), AudioPermissionContract {

    override suspend fun onAction(action: CreateAlifeAction) {
        super.onAction(actionMapper.map(action, viewModelScope))
    }

    override suspend fun onEffect(navController: NavController, effect: CreateAlifeEffect) {
        when (effect) {
            is CreateAlifeEffect.VideoToMainPage -> effect.scrollToVideoPage()
            else -> super.onEffect(navController, effect)
        }
    }

    override fun audioBoxReduce(permissionStatus: PermissionStatus) {
        reduce(CreateAlifeAction.AudioPermission(permissionStatus))
    }
}