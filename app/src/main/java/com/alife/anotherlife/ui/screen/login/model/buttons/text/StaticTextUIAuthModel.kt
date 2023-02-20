package com.alife.anotherlife.ui.screen.login.model.buttons.text

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.ui.screen.login.LoginViewModel

sealed class StaticTextUIAuthModel(
    @StringRes textRes: Int,
    private val modifier: Modifier = Modifier
) : TextUIAuthModel(textRes) {

    @Composable
    override fun Button(viewModel: LoginViewModel, modifier: Modifier) {
        TextBase(
            textResId = textRes,
            fontSize = 14.sp,
            modifier = this.modifier.then(modifier)
        )
    }


    class Logo : StaticTextUIAuthModel(
        R.string.vertical_logo,
        Modifier.padding(horizontal = 25.dp).width(5.dp)
    )

    class Hint : StaticTextUIAuthModel(
        R.string.authorization_type,
    )
}