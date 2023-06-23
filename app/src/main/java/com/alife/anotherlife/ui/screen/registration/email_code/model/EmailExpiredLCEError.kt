package com.alife.anotherlife.ui.screen.registration.email_code.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.state.lce.ErrorScreen
import com.alife.anotherlife.core.ui.state.lce.LCEModel

class EmailExpiredLCEError(private val onBack: () -> Unit) : LCEModel.Error {

    @Composable
    override fun LCEContent(modifier: Modifier) {
        ErrorScreen(
            stringResource(R.string.exception),
            stringResource(R.string.email_code_critical_error),
            stringResource(R.string.back),
            Modifier,
            onBack
        )
    }
}