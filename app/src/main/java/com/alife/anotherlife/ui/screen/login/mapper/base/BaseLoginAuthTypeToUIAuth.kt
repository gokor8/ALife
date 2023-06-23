package com.alife.anotherlife.ui.screen.login.mapper.base

import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.domain.login.content.entity.LoginAuthTypeEntity
import com.alife.domain.login.content.entity.MockImageAuthTypeEntity

interface BaseLoginAuthTypeToUIAuth {

    fun map(
        inputModel: LoginAuthTypeEntity,
        thirdAuthType: MockImageAuthTypeEntity?
    ): List<UIAuthModel>
}