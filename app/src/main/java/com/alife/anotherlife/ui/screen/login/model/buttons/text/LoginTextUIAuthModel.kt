package com.alife.anotherlife.ui.screen.login.model.buttons.text

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alife.anotherlife.R
import com.alife.anotherlife.core.composable.button.ButtonBase
import com.alife.anotherlife.core.composable.image.ImageBase
import com.alife.anotherlife.core.composable.text.TextBase
import com.alife.anotherlife.ui.screen.login.LoginViewModel
import com.alife.anotherlife.ui.screen.login.model.AuthType
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthType

sealed class LoginTextUIAuthModel(@StringRes textId: Int) : TextUIAuthModel(textId), UIAuthType {

    protected abstract val radius: CornerSize


    class LoginIn : LoginTextUIAuthModel(R.string.login_in) {

        override val authType: AuthType = AuthType.LOGIN_IN

        override val radius = CornerSize(25.dp)

        @Composable
        override fun Button(viewModel: LoginViewModel) {
            ButtonBase(
                onClick = { viewModel.onAuthTypeAction(authType) },
                shape = RoundedCornerShape(radius),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
            ) {
                TextBase(textResId = textRes)
            }
        }
    }

    class Registration : LoginTextUIAuthModel(R.string.registration) {

        override val authType: AuthType = AuthType.REGISTRATION

        override val radius = CornerSize(10.dp)

        @Composable
        override fun Button(viewModel: LoginViewModel) {
            ButtonBase(
                onClick = { viewModel.onAuthTypeAction(authType) },
                shape = RoundedCornerShape(radius),
                contentPadding = PaddingValues(horizontal = 22.dp, vertical = 10.dp)
            ) {
                ImageBase(resId = R.drawable.ic_profile)
                Spacer(modifier = Modifier.padding(start = 5.dp))
                TextBase(textResId = textRes)
            }
        }
    }
}