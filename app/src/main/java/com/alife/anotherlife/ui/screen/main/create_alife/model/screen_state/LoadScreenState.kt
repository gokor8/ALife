package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

class LoadScreenState : ScreenState.AbstractScreenState(Alignment.Center) {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun SafeContent(
        permissionState: PermissionState,
        viewModel: CreateAlifeViewModel,
    ) {
        CircularProgressIndicator(strokeWidth = 2.dp)
    }
}