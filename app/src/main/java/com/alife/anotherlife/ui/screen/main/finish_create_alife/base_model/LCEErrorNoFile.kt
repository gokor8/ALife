package com.alife.anotherlife.ui.screen.main.finish_create_alife.base_model

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.alife.anotherlife.R
import com.alife.anotherlife.core.ui.state.lce.ErrorScreen
import com.alife.anotherlife.core.ui.state.lce.LCEModel

class LCEErrorNoFile(
    @StringRes private val titleError: Int,
    @StringRes private val descriptionError: Int,
    private val errorContract: FinishErrorContract
) : LCEModel.Error {

    @Composable
    override fun LCEContent(modifier: Modifier) {
        ErrorScreen(
            title = stringResource(titleError),
            description = stringResource(descriptionError),
            buttonText = stringResource(R.string.back),
            onTry = { errorContract.onBackEffect() }
        )
    }
}