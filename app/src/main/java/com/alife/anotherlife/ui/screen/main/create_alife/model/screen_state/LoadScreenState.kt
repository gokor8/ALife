package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

abstract class LoadScreenState : ScreenState.AbstractScreenState(Alignment.Center) {

    @Composable
    override fun SafeContent(viewModel: CreateAlifeViewModel) {
        CircularProgressIndicator(strokeWidth = 2.dp)
    }
}