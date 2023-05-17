package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.button.TransparentStrokeButton
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.core.composable.text.style.Title22Style
import com.alife.anotherlife.core.ui.permission.PermissionStatus
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi

abstract class ErrorPermissionScreenState : ScreenState {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun Content(viewModel: CreateAlifeViewModel, modifier: Modifier) {
        val state = viewModel.getUIState()

        val activityLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult(),
            onResult = { onSettingAction(viewModel) }
        )

       viewModel.cameraPermission.requirePermission { status ->
            if(status is PermissionStatus.Success) onSettingAction(viewModel)
       }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            TextBase(
                textResId = R.string.camera_blocking_error_camera,
                textAlign = TextAlign.Center,
                style = Title22Style().style()
            )
            Spacer(modifier = Modifier.padding(bottom = 30.dp))

            TransparentStrokeButton(R.string.camera_blocking_error_camera) {
                activityLauncher.launch(state.settingsIntent)
            }
        }
    }

    protected abstract fun onSettingAction(viewModel: CreateAlifeViewModel)

//    override fun hashCode(): Int {
//        val hashcode = this.javaClass.simpleName.hashCode()
//        Log.d("Hashcode", "${hashcode}")
//        return hashcode
//    }
}