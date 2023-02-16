package com.alife.anotherlife.ui.screen.login.model

import com.alife.anotherlife.ui.screen.login.mapper.base.BaseListAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.domain.login.entity.AuthTypeEntity

class FakeListAuthTypeToUIAuth : BaseListAuthTypeToUIAuth {

    override fun map(inputModel: List<AuthTypeEntity>): List<UIAuthModel> {
        return inputModel.map { authType ->
            when (authType) {
                is TestAuthTypeEntity.TestFirstAuthType -> FakeUIAuthModel.FakeFirst()
                is TestAuthTypeEntity.TestSecondAuthType -> FakeUIAuthModel.FakeSecond()
                else -> UIAuthModel.Empty()
            }
        }
    }
}