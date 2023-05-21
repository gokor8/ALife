package com.alife.data.repository.registration.mapper

import com.alife.data.data_source.cache.shared.model.CacheModel
import com.alife.data.repository.registration.model.birthday.BirthdayRegReadModel
import com.alife.data.repository.registration.model.email.EmailRegReadModel
import com.alife.data.repository.registration.model.name.NameRegReadModel
import com.alife.data.repository.registration.model.username.UsernameRegReadModel
import com.alife.domain.core.MappingException
import com.alife.domain.registration.usecase.base.entity.ReadCacheInputEntity
import com.alife.domain.registration.usecase.birthday.BirthdayReadCacheEntity
import com.alife.domain.registration.usecase.email.save_read.EmailReadCacheEntity
import com.alife.domain.registration.usecase.name.NameReadCacheEntity
import com.alife.domain.registration.usecase.username.UsernameReadCacheEntity
import javax.inject.Inject

class RegEntityToReadRegModel @Inject constructor() : BaseRegEntityToReadRegModel {

    override fun map(inputModel: ReadCacheInputEntity<*>): CacheModel.Read<*> {
        return when(inputModel) {
            is NameReadCacheEntity -> NameRegReadModel()
            is UsernameReadCacheEntity -> UsernameRegReadModel()
            is BirthdayReadCacheEntity -> BirthdayRegReadModel()
            is EmailReadCacheEntity -> EmailRegReadModel()
            else -> throw MappingException()
        }
    }
}