package com.alife.anotherlife.ui.screen.login.mapper

import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseMockAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.picture.PictureUIAuthModel
import com.alife.domain.login.entity.MockImageAuthTypeEntity
import javax.inject.Inject

class MockAuthTypeToUIAuth @Inject constructor(): BaseMockAuthTypeToUIAuth {

    override fun map(inputModel: MockImageAuthTypeEntity): UIAuthModel = when(inputModel) {
        is MockImageAuthTypeEntity.VKAuthTypeEntity -> {
            PictureUIAuthModel.ResImageUIAuthModel(R.drawable.ic_vk)
        }
        is MockImageAuthTypeEntity.InstagramAuthTypeEntity -> {
            PictureUIAuthModel.ResImageUIAuthModel(R.drawable.ic_instagram)
        }
        is MockImageAuthTypeEntity.GoogleAuthTypeEntity -> {
            PictureUIAuthModel.ResImageUIAuthModel(R.drawable.ic_google)
        }
    }
}