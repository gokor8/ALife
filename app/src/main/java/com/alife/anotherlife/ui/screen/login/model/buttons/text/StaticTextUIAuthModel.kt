package com.alife.anotherlife.ui.screen.login.model.buttons.text

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.ui.screen.login.LoginViewModel

sealed class StaticTextUIAuthModel(
    @StringRes textRes: Int,
    private val modifier: Modifier = Modifier
    ) : TextUIAuthModel(textRes) {

    @Composable
    override fun Button(viewModel: LoginViewModel) {
        TextBase(
            textResId = textRes,
            modifier = modifier
        )
    }


    class Logo : StaticTextUIAuthModel(
        R.string.horizontal_logo,
        Modifier.wrapContentHeight().width(5.dp)
    )

    class Hint : StaticTextUIAuthModel(R.string.authorization_type)
}