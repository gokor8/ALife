package com.alife.anotherlife.ui.screen.login.model

import com.alife.anotherlife.ui.screen.login.mapper.base.BaseListAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.domain.login.content.entity.AuthTypeEntity

class FakeListAuthTypeToUIAuth : BaseListAuthTypeToUIAuth {

    override fun map(inputModel: List<AuthTypeEntity>): List<UIAuthModel> {
        return inputModel.map { authType ->
            when (authType) {
                is FakeAuthTypeEntity.FakeFirstAuthType -> FakeUIAuthModel.FakeFirst()
                is FakeAuthTypeEntity.FakeSecondAuthType -> FakeUIAuthModel.FakeSecond()
                else -> UIAuthModel.Empty()
            }
        }
    }
}