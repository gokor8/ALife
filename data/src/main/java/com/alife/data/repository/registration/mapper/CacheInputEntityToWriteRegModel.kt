package com.alife.data.repository.registration.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.data_source.cache.shared.model.CacheModel
import com.alife.data.repository.registration.model.birthday.BirthdayRegWriteModel
import com.alife.data.repository.registration.model.email.EmailRegWriteModel
import com.alife.data.repository.registration.model.name.NameRegWriteModel
import com.alife.data.repository.registration.model.username.UsernameRegWriteModel
import com.alife.domain.core.MappingException
import com.alife.domain.registration.usecase.base.entity.RegCacheInputEntity
import com.alife.domain.registration.usecase.reg_log.birthday.BirthdaySaveCacheEntity
import com.alife.domain.registration.usecase.reg_log.email.save_read.EmailSaveCacheEntity
import com.alife.domain.registration.usecase.reg_log.name.NameSaveCacheEntity
import com.alife.domain.registration.usecase.reg_log.username.UsernameSaveCacheEntity
import javax.inject.Inject

class CacheInputEntityToWriteRegModel @Inject constructor() :
    Mapper<RegCacheInputEntity.Save<*>, CacheModel.Write<*>> {

    override fun map(inputModel: RegCacheInputEntity.Save<*>): CacheModel.Write<*> {
        return when(inputModel) {
            is NameSaveCacheEntity -> NameRegWriteModel(inputModel.name)
            is UsernameSaveCacheEntity -> UsernameRegWriteModel(inputModel.username)
            is BirthdaySaveCacheEntity -> BirthdayRegWriteModel(inputModel.birthday)
            is EmailSaveCacheEntity -> EmailRegWriteModel(inputModel.email)
            else -> throw MappingException()
        }
    }
}