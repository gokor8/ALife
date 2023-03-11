package com.alife.domain.login.content

import com.alife.domain.login.content.base.BaseLoginAuthTypeUseCase
import com.alife.domain.login.content.entity.DefaultAuthTypeEntity
import com.alife.domain.login.content.entity.LoginAuthTypeEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LoginAuthTypeUseCase @Inject constructor(
    override val dispatcher: CoroutineDispatcher
) : BaseLoginAuthTypeUseCase() {

    override fun getLoginAuthTypes(): LoginAuthTypeEntity = LoginAuthTypeEntity(
        DefaultAuthTypeEntity.HorizontalLogoEntity(),
        DefaultAuthTypeEntity.RegistrationEntity(),
        DefaultAuthTypeEntity.LoginInEntity(),
    )
}