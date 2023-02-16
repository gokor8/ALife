package com.alife.anotherlife.ui.screen.login.mapper

import com.alife.anotherlife.R
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseMockAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.model.buttons.picture.RPictureUIAuthModel
import com.alife.domain.login.entity.MockImageAuthTypeEntity
import javax.inject.Inject

class MockAuthTypeToUIAuth @Inject constructor(): BaseMockAuthTypeToUIAuth {

    override fun map(inputModel: MockImageAuthTypeEntity): RPictureUIAuthModel = when(inputModel) {
        is MockImageAuthTypeEntity.VKAuthTypeEntity -> {
            RPictureUIAuthModel.ResImageUIAuthModelR(R.drawable.ic_vk)
        }
        is MockImageAuthTypeEntity.InstagramAuthTypeEntity -> {
            RPictureUIAuthModel.ResImageUIAuthModelR(R.drawable.ic_instagram)
        }
        is MockImageAuthTypeEntity.GoogleAuthTypeEntity -> {
            RPictureUIAuthModel.ResImageUIAuthModelR(R.drawable.ic_google)
        }
    }
}