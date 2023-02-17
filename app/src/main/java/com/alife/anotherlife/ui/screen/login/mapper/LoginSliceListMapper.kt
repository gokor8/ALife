package com.alife.anotherlife.ui.screen.login.mapper

import com.alife.core.mapper.ListMapper
import com.alife.domain.login.entity.AuthTypeEntity
import javax.inject.Inject

class LoginSliceListMapper @Inject constructor(): ListMapper<AuthTypeEntity> {

    override fun map(inputModel: List<AuthTypeEntity>): List<AuthTypeEntity> {
        return if(inputModel.size > 1)
            inputModel.subList(1, inputModel.size)
        else
            emptyList()
    }
}