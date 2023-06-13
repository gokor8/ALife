package com.alife.anotherlife.ui.screen.main.navigation_bar.map.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.state.lce.EmptyError
import com.alife.anotherlife.core.ui.state.lce.ErrorScreen
import com.alife.anotherlife.core.ui.text.TextWrapper

object LceErrorMapPermissionProvider : EmptyError

class LceErrorMapPermission {

    @Composable
    fun LCEContent(modifier: Modifier, onTry: () -> Unit) {
        ErrorScreen(
            TextWrapper.ResWrapper(R.string.map_error_title).getString(),
            TextWrapper.ResWrapper(R.string.map_error_descripion).getString(),
            TextWrapper.ResWrapper(R.string.repeat).getString(),
            modifier,
            onTry
        )
    }
}