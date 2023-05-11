package com.alife.data.repository.registration.mapper

import com.alife.data.data_source.cache.shared.model.CacheModel
import com.alife.data.repository.registration.model.birthday.BirthdayRegWriteModel
import com.alife.data.repository.registration.model.email.EmailRegWriteModel
import com.alife.data.repository.registration.model.name.NameRegWriteModel
import com.alife.data.repository.registration.model.username.UsernameRegWriteModel
import com.alife.domain.core.MappingException
import com.alife.domain.registration.usecase.base.entity.SaveRegInputEntity
import com.alife.domain.registration.usecase.birthday.BirthdaySaveRegEntity
import com.alife.domain.registration.usecase.email.save_read.EmailSaveRegEntity
import com.alife.domain.registration.usecase.name.NameSaveRegEntity
import com.alife.domain.registration.usecase.username.UsernameSaveRegEntity
import javax.inject.Inject

class RegEntityToWriteRegModel @Inject constructor() : BaseRegEntityToWriteRegModel {

    override fun map(inputModel: SaveRegInputEntity<*>): CacheModel.Write<*> {
        return when(inputModel) {
            is NameSaveRegEntity -> NameRegWriteModel(inputModel.name)
            is UsernameSaveRegEntity -> UsernameRegWriteModel(inputModel.username)
            is BirthdaySaveRegEntity -> BirthdayRegWriteModel(inputModel.birthday)
            is EmailSaveRegEntity -> EmailRegWriteModel(inputModel.email)
            else -> throw MappingException()
        }
    }
}