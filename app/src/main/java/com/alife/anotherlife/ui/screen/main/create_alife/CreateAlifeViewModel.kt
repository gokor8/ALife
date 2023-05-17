package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.permission.audio.AudioPermission
import com.alife.anotherlife.core.ui.permission.audio.AudioPermissionContract
import com.alife.anotherlife.core.ui.permission.camera.CameraPermission
import com.alife.anotherlife.core.ui.permission.camera.MomentaryCameraPermission
import com.alife.anotherlife.core.ui.view_model.ViewModelLCE
import com.alife.anotherlife.ui.screen.main.create_alife.mapper.BaseActionScopedMapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.base.BaseCameraSetupFactory
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.image.capture.BaseCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.capture.BaseVideoCaptureWrapper
import com.alife.anotherlife.ui.screen.main.create_alife.state.AbstractDialogErrorEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.BaseSnackBarEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateAlifeViewModel @Inject constructor(
    reducer: BaseCreateAlifeReducerBase,
    private val actionMapper: BaseActionScopedMapper,
    val momentaryCameraPermission: MomentaryCameraPermission,
    val audioPermission: AudioPermission,
    val imageSetupFactory: BaseCameraSetupFactory<BaseCaptureWrapper>,
    val videoSetupFactory: BaseCameraSetupFactory<BaseVideoCaptureWrapper>,
) : ViewModelLCE<BaseCreateAlifeReducerBase, CreateAlifeAction, CreateAlifeState, CreateAlifeEffect>(
    reducer
), AudioPermissionContract {

    override suspend fun onAction(action: CreateAlifeAction) {
        super.onAction(actionMapper.map(action, viewModelScope))
    }

    override fun audioBoxReduce(permissionStatus: PermissionStatus) {
        reduce(CreateAlifeAction.AudioPermission(permissionStatus))
    }

    @OptIn(ExperimentalFoundationApi::class)
    suspend fun collectEffect(
        navController: NavController,
        pagerState: PagerState,
        onSnackBarEffect: suspend (BaseSnackBarEffect) -> Unit,
        onDialogError: suspend (AbstractDialogErrorEffect) -> Unit
    ) {
        reducerVM.getEffectCollector().collect { effect ->
            when(effect) {
                is CreateAlifeEffect.VideoToMainPage -> effect.scrollToVideoPage(pagerState)
                is BaseSnackBarEffect -> onSnackBarEffect(effect)
                is AbstractDialogErrorEffect -> onDialogError(effect)
                else -> onEffect(navController, effect)
            }
        }
    }
}