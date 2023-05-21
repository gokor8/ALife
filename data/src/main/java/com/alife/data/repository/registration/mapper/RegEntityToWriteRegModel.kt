package com.alife.data.repository.registration.mapper

import com.alife.data.data_source.cache.shared.model.CacheModel
import com.alife.data.repository.registration.model.birthday.BirthdayRegWriteModel
import com.alife.data.repository.registration.model.email.EmailRegWriteModel
import com.alife.data.repository.registration.model.name.NameRegWriteModel
import com.alife.data.repository.registration.model.username.UsernameRegWriteModel
import com.alife.domain.core.MappingException
import com.alife.domain.registration.usecase.base.entity.SaveCacheInputEntity
import com.alife.domain.registration.usecase.birthday.BirthdaySaveCacheEntity
import com.alife.domain.registration.usecase.email.save_read.EmailSaveCacheEntity
import com.alife.domain.registration.usecase.name.NameSaveCacheEntity
import com.alife.domain.registration.usecase.username.UsernameSaveCacheEntity
import javax.inject.Inject

class RegEntityToWriteRegModel @Inject constructor() : BaseRegEntityToWriteRegModel {

    override fun map(inputModel: SaveCacheInputEntity<*>): CacheModel.Write<*> {
        return when(inputModel) {
            is NameSaveCacheEntity -> NameRegWriteModel(inputModel.name)
            is UsernameSaveCacheEntity -> UsernameRegWriteModel(inputModel.username)
            is BirthdaySaveCacheEntity -> BirthdayRegWriteModel(inputModel.birthday)
            is EmailSaveCacheEntity -> EmailRegWriteModel(inputModel.email)
            else -> throw MappingException()
        }
    }
}