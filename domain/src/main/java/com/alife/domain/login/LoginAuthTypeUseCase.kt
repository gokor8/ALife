package com.alife.domain.login

import com.alife.domain.login.base.BaseLoginAuthTypeUseCase
import com.alife.domain.login.entity.AuthTypeEntity
import com.alife.domain.login.entity.DefaultAuthTypeEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LoginAuthTypeUseCase @Inject constructor(
    override val dispatcher: CoroutineDispatcher
) : BaseLoginAuthTypeUseCase() {

    override fun getAuthTypes(): List<AuthTypeEntity> = listOf(
        DefaultAuthTypeEntity.HorizontalLogoEntity(),
        DefaultAuthTypeEntity.HintEntity(),
        DefaultAuthTypeEntity.LoginInEntity(),
        DefaultAuthTypeEntity.RegistrationEntity(),
    )
}