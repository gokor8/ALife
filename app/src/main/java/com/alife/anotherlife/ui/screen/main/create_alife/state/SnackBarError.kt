package com.alife.anotherlife.ui.screen.main.create_alife.state

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.snackbar.OnlyTextSnackBar
import com.alife.domain.core.delay.DelayWrapper

abstract class SnackBarError(
    @StringRes private val text: Int
) : CreateAlifeEffect.BaseSnackBarError {
    override suspend fun showSnackBar(snackBarVisibility: MutableState<CreateAlifeEffect.BaseSnackBarError>) {
        snackBarVisibility.value = this
        DelayWrapper.Short().delay()
        snackBarVisibility.value = EmptySnackError()
    }

    @Composable
    override fun ShowSnackBar(modifier: Modifier) {
        OnlyTextSnackBar(stringResource(text), modifier = modifier)
    }
}

class SnackVideoError : SnackBarError(text = R.string.camera_snackbar_video_error)

class DefaultSnackError(@StringRes text: Int) : SnackBarError(text)

class EmptySnackError : CreateAlifeEffect.BaseSnackBarError