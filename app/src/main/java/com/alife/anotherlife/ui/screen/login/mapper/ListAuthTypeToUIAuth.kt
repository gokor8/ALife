package com.alife.anotherlife.ui.screen.login.mapper

import com.alife.anotherlife.ui.screen.login.mapper.base.BaseDefaultAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseListAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.mapper.base.BaseMockAuthTypeToUIAuth
import com.alife.anotherlife.ui.screen.login.model.buttons.UIAuthModel
import com.alife.domain.login.content.entity.AuthTypeEntity
import com.alife.domain.login.content.entity.DefaultAuthTypeEntity
import com.alife.domain.login.content.entity.MockImageAuthTypeEntity
import javax.inject.Inject

class ListAuthTypeToUIAuth @Inject constructor(
    private val defaultAuthTypeToUIAuth: BaseDefaultAuthTypeToUIAuth,
    private val mockImageAuthTypeEntity: BaseMockAuthTypeToUIAuth
) : BaseListAuthTypeToUIAuth {

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