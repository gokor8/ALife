package com.alife.anotherlife.ui.screen.login.mapper

import com.alife.anotherlife.ui.screen.login.mapper.base.BaseLoginAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.model.buttons.ContainerLoginUIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.text.LoginTextUIAuthModel
import com.alife.anotherlife.ui.screen.login.model.buttons.text.StaticTextUIAuthModel
import com.alife.domain.login.entity.LoginAuthTypeEntity
import com.alife.domain.login.entity.MockImageAuthTypeEntity
import javax.inject.Inject

class LoginAuthTypeToUIAuth @Inject constructor(
    private val mockAuthTypeToUIAuth: MockAuthTypeToUIAuth
) : BaseLoginAuthTypeToUIAuth {

    override fun map(
        inputModel: LoginAuthTypeEntity,
        thirdAuthType: MockImageAuthTypeEntity?
    ): List<UIAuthModel> = listOf(
        StaticTextUIAuthModel.Logo(),
        ContainerLoginUIAuthModel(
            LoginTextUIAuthModel.LoginIn(),
            LoginTextUIAuthModel.Registration(),
            thirdAuthType?.let { mockAuthTypeToUIAuth.map(thirdAuthType) } ?: UIAuthModel.Empty()
        )
    )
}