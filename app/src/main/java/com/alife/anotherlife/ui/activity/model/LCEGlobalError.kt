package com.alife.anotherlife.ui.activity.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.state.lce.ErrorScreen
import com.alife.anotherlife.core.ui.state.lce.LCEModel

class LCEGlobalError : LCEModel.Error {

    @Composable
    override fun LCEContent(modifier: Modifier) {
        ErrorScreen(
            title = stringResource(R.string.global_exception),
            description = stringResource(R.string.try_later)
        )
    }
}