package com.alife.anotherlife.core.ui.state.lce

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.alife.anotherlife.R

class GenericLCEError(private val onTry: () -> Unit) : LCEModel.Error {

    @Composable
    override fun LCEContent(modifier: Modifier) {
        ErrorScreen(
            stringResource(R.string.generic_exception_title),
            stringResource(R.string.generic_exception_description),
            stringResource(R.string.repeat),
            Modifier,
            onTry
        )
    }
}