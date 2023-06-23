package com.alife.anotherlife.ui.screen.login.mapper

import com.alife.core.mapper.ListMapperSingle
import com.alife.domain.login.content.entity.AuthTypeEntity
import javax.inject.Inject

class LoginSliceListMapperSingle @Inject constructor(): ListMapperSingle<AuthTypeEntity> {

    override fun map(inputModel: List<AuthTypeEntity>): List<AuthTypeEntity> {
        return if(inputModel.size > 1)
            inputModel.subList(1, inputModel.size)
        else
            emptyList()
    }
}