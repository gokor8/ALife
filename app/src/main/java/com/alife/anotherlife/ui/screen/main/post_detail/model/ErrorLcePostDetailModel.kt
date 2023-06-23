package com.alife.anotherlife.ui.screen.main.post_detail.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.state.lce.ErrorScreen
import com.alife.anotherlife.core.ui.state.lce.LCEModel

object ErrorLcePostDetailModelProvider : LCEModel.Error {

    @Composable
    override fun LCEContent(modifier: Modifier) = Unit
}

class ErrorLcePostDetailModel {

    @Composable
    fun ErrorContent(onBackClick: () -> Unit) {
        ErrorScreen(
            title = stringResource(R.string.profile_error_load_data),
            description = stringResource(R.string.try_later),
            buttonText = stringResource(R.string.back),
            onTry = onBackClick
        )
    }
}