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

    @Composable
    fun Content(
        viewModel: CreateAlifeViewModel,
        modifier: Modifier,
    )

    abstract class AbstractScreenState(
        private val contentAlignment: Alignment = Alignment.TopStart,
    ) : ScreenState {

        @Composable
        override fun Content(
            viewModel: CreateAlifeViewModel,
            modifier: Modifier,
        ) {
            Box(
                contentAlignment = contentAlignment,
                modifier = modifier.fillMaxSize()
            ) {
                SafeContent(viewModel = viewModel)
            }
        }

        @Composable
        protected abstract fun SafeContent(viewModel: CreateAlifeViewModel)
    }
}