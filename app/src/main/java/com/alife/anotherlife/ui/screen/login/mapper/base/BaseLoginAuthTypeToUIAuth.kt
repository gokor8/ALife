package com.alife.anotherlife.ui.screen.login.mapper.base

import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.domain.login.entity.LoginAuthTypeEntity
import com.alife.domain.login.entity.MockImageAuthTypeEntity

interface BaseLoginAuthTypeToUIAuth {

    fun map(
        inputModel: LoginAuthTypeEntity,
        thirdAuthType: MockImageAuthTypeEntity?
    ): List<UIAuthModel>
}