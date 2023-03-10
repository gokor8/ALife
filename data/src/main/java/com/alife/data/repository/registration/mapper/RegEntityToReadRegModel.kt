package com.alife.data.repository.registration.mapper

import com.alife.data.data_source.model.CacheModel
import com.alife.data.repository.registration.model.name.NameRegReadModel
import com.alife.data.repository.registration.model.username.UsernameRegReadModel
import com.alife.domain.core.MappingException
import com.alife.domain.registration.entity.RegistrationEntity
import com.alife.domain.registration.usecase.name.NameReadRegEntity
import com.alife.domain.registration.usecase.username.UsernameReadRegEntity
import javax.inject.Inject

class RegEntityToReadRegModel @Inject constructor() : BaseRegEntityToReadRegModel {

    override fun map(inputModel: RegistrationEntity<*>): CacheModel.Read<*> {
        return when(inputModel) {
            is NameReadRegEntity -> NameRegReadModel()
            is UsernameReadRegEntity -> UsernameRegReadModel()
            else -> throw MappingException()
        }
    }
}