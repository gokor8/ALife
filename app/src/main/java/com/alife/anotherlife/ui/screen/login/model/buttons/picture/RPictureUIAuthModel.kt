package com.alife.anotherlife.ui.screen.login.model.buttons.picture

import android.media.Image
import androidx.compose.runtime.Composable
import com.alife.anotherlife.core.composable.image.ImageBase
import com.alife.anotherlife.ui.screen.login.LoginViewModel
import com.alife.anotherlife.ui.screen.login.model.AuthType
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthType

sealed class RPictureUIAuthModel : UIAuthModel, UIAuthType {

    override val authType: AuthType = AuthType.AUTH_SERVICE


    class ResImageUIAuthModelR(
        private val imageResId: Int,
    ) : RPictureUIAuthModel() {

        @Composable
        override fun Button(viewModel: LoginViewModel) {
            ImageBase(resId = imageResId)
        }
    }

    class ImageUIAuthModelR(
        private val image: Image
    ) : RPictureUIAuthModel() {

        @Composable
        override fun Button(viewModel: LoginViewModel) {

        }
    }

}