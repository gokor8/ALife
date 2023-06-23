package com.alife.anotherlife.ui.screen.main.navigation_bar.profile.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.state.lce.ErrorScreen
import com.alife.anotherlife.core.ui.state.lce.LCEModel

object LceErrorProfileProvider : LCEModel.Error {
    @Composable
    override fun LCEContent(modifier: Modifier) = Unit
}

class LceErrorProfileLoad {

    @Composable
    fun LCEContent(onTry: () -> Unit) {
        ErrorScreen(
            stringResource(R.string.profile_error_title),
            stringResource(R.string.profile_error_load_data),
            onTry = onTry
        )
    }
}