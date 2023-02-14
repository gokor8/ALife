package com.alife.anotherlife.ui.screen.login.model.buttons.picture

import android.media.Image
import androidx.compose.runtime.Composable
import com.alife.anotherlife.core.composable.image.ImageBase
import com.alife.anotherlife.ui.screen.login.LoginViewModel
import com.alife.anotherlife.ui.screen.login.model.AuthType
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthType

sealed class PictureUIAuthModel : UIAuthModel, UIAuthType {

    override val authType: AuthType = AuthType.AUTH_SERVICE


    class ResImageUIAuthModel(
        private val imageResId: Int,
    ) : PictureUIAuthModel() {

        @Composable
        override fun Button(viewModel: LoginViewModel) {
            ImageBase(resId = imageResId)
        }
    }

    class ImageUIAuthModel(
        private val image: Image
    ) : PictureUIAuthModel() {

        @Composable
        override fun Button(viewModel: LoginViewModel) {

        }
    }

}