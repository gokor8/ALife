package com.alife.anotherlife.ui.screen.main.create_alife

import androidx.navigation.NavController
import com.alife.anotherlife.core.composable.mvi_extensions.DefaultViewModel
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.core.ui.permission.audio.AudioPermission
import com.alife.anotherlife.core.ui.permission.audio.AudioPermissionContract
import com.alife.anotherlife.core.ui.permission.camera.CameraPermission
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeAction
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeEffect
import com.alife.anotherlife.ui.screen.main.create_alife.state.CreateAlifeState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateAlifeViewModel @Inject constructor(
    reducer: BaseCreateAlifeReducer,
    val cameraPermission: CameraPermission,
    val audioPermission: AudioPermission,
) : DefaultViewModel<BaseCreateAlifeReducer, CreateAlifeAction, CreateAlifeState, CreateAlifeEffect>(reducer), AudioPermissionContract {

    override suspend fun onEffect(navController: NavController, effect: CreateAlifeEffect) {
        if(effect is CreateAlifeEffect.VideoToMainPage)
            effect.scrollToVideoPage()
        else
            super.onEffect(navController, effect)
    }

    override fun audioBoxReduce(permissionStatus: PermissionStatus) {
        reduce(CreateAlifeAction.AudioPermission(permissionStatus))
    }
}