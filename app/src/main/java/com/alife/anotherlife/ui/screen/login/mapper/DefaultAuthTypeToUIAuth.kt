package com.alife.anotherlife.ui.screen.login.mapper

import com.alife.anotherlife.ui.screen.login.mapper.base.BaseDefaultAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.text.LoginTextUIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.text.StaticTextUIAuthModel
import com.alife.domain.login.content.entity.DefaultAuthTypeEntity
import javax.inject.Inject

class DefaultAuthTypeToUIAuth @Inject constructor() : BaseDefaultAuthTypeToUIAuth {

    override fun map(inputModel: DefaultAuthTypeEntity): UIAuthModel = when (inputModel) {
        is DefaultAuthTypeEntity.LoginInEntity -> LoginTextUIAuthModel.LoginIn()
        is DefaultAuthTypeEntity.RegistrationEntity -> LoginTextUIAuthModel.Registration()
        is DefaultAuthTypeEntity.HorizontalLogoEntity -> StaticTextUIAuthModel.Logo()
        is DefaultAuthTypeEntity.HintEntity -> StaticTextUIAuthModel.Hint()
    }
}