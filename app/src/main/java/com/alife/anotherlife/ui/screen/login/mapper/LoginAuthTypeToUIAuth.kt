package com.alife.anotherlife.ui.screen.login.mapper

import com.alife.anotherlife.ui.screen.login.mapper.base.BaseDefaultAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseLoginAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseMockAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.domain.login.entity.AuthTypeEntity
import com.alife.domain.login.entity.DefaultAuthTypeEntity
import com.alife.domain.login.entity.MockImageAuthTypeEntity
import javax.inject.Inject

class LoginAuthTypeToUIAuth @Inject constructor(
    private val defaultAuthTypeToUIAuth: BaseDefaultAuthTypeToUIAuth,
    private val mockImageAuthTypeEntity: BaseMockAuthTypeToUIAuth
) : BaseLoginAuthTypeToUIAuth {

    override fun map(inputModel: List<AuthTypeEntity>): List<UIAuthModel> {
        return inputModel.map { entity ->
            when (entity) {
                is DefaultAuthTypeEntity -> defaultAuthTypeToUIAuth.map(entity)
                is MockImageAuthTypeEntity -> mockImageAuthTypeEntity.map(entity)
                else -> UIAuthModel.Empty()
            }
        }
    }
}