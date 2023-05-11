package com.alife.data.repository.registration.mapper

import com.alife.data.data_source.cache.shared.model.CacheModel
import com.alife.data.repository.registration.model.birthday.BirthdayRegReadModel
import com.alife.data.repository.registration.model.email.EmailRegReadModel
import com.alife.data.repository.registration.model.name.NameRegReadModel
import com.alife.data.repository.registration.model.username.UsernameRegReadModel
import com.alife.domain.core.MappingException
import com.alife.domain.registration.usecase.base.entity.ReadRegInputEntity
import com.alife.domain.registration.usecase.birthday.BirthdayReadRegEntity
import com.alife.domain.registration.usecase.email.save_read.EmailReadRegEntity
import com.alife.domain.registration.usecase.name.NameReadRegEntity
import com.alife.domain.registration.usecase.username.UsernameReadRegEntity
import javax.inject.Inject

class RegEntityToReadRegModel @Inject constructor() : BaseRegEntityToReadRegModel {

    override fun map(inputModel: ReadRegInputEntity<*>): CacheModel.Read<*> {
        return when(inputModel) {
            is NameReadRegEntity -> NameRegReadModel()
            is UsernameReadRegEntity -> UsernameRegReadModel()
            is BirthdayReadRegEntity -> BirthdayRegReadModel()
            is EmailReadRegEntity -> EmailRegReadModel()
            else -> throw MappingException()
        }
    }
}