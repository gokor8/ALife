package com.alife.data.repository.registration.mapper

import com.alife.data.data_source.model.CacheModel
import com.alife.data.repository.registration.model.name.NameRegWriteModel
import com.alife.domain.core.MappingException
import com.alife.domain.registration.entity.RegistrationEntity
import com.alife.domain.registration.usecase.name.NameSaveRegEntity
import com.alife.domain.registration.usecase.username.UsernameSaveRegEntity
import javax.inject.Inject

class RegEntityToWriteRegModel @Inject constructor() : BaseRegEntityToWriteRegModel {

    override fun map(inputModel: RegistrationEntity<*>): CacheModel.Write<*> {
        return when(inputModel) {
            is NameSaveRegEntity -> NameRegWriteModel(inputModel.name)
            is UsernameSaveRegEntity -> NameRegWriteModel(inputModel.username)
            else -> throw MappingException()
        }
    }
}