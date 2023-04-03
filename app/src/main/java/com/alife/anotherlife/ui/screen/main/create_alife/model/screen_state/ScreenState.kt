package com.alife.anotherlife.ui.screen.main.create_alife.model.screen_state

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.alife.anotherlife.ui.screen.main.create_alife.CreateAlifeViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

@Stable
interface ScreenState {

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun Content(
        permissionState: PermissionState,
        viewModel: CreateAlifeViewModel,
        modifier: Modifier,
    )

    abstract class AbstractScreenState(
        private val contentAlignment: Alignment = Alignment.TopStart,
    ) : ScreenState {

        @OptIn(ExperimentalPermissionsApi::class)
        @Composable
        override fun Content(
            permissionState: PermissionState,
            viewModel: CreateAlifeViewModel,
            modifier: Modifier,
        ) {
            Box(
                contentAlignment = contentAlignment,
                modifier = modifier.fillMaxSize()
            ) {
                SafeContent(permissionState, viewModel = viewModel)
            }
        }

        @OptIn(ExperimentalPermissionsApi::class)
        @Composable
        protected abstract fun SafeContent(
            permissionState: PermissionState,
            viewModel: CreateAlifeViewModel,
        )
    }
}