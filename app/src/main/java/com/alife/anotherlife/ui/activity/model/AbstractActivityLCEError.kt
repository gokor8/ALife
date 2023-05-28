package com.alife.anotherlife.ui.activity.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.alife.anotherlife.core.ui.state.lce.ErrorScreen
import com.alife.anotherlife.core.ui.state.lce.LCEModel

interface ActivityLCEErrorContract {

    fun showContent()
}

abstract class AbstractActivityLCEError(
    private val title: Int,
    private val description: Int,
    private val buttonText: Int,
    private val onTry: () -> Unit
) : LCEModel.Error {

    constructor(
        title: Int,
        description: Int,
        buttonText: Int,
        contract: ActivityLCEErrorContract
    ) : this(title, description, buttonText, contract::showContent)

    @Composable
    override fun LCEContent(modifier: Modifier) {
        ErrorScreen(
            title = stringResource(title),
            description = stringResource(description),
            buttonText = stringResource(buttonText),
            onTry = onTry
        )
    }
}