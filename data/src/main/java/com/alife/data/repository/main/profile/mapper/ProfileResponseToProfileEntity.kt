package com.alife.data.repository.main.profile.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.repository.main.profile.model.ResponseProfileInfoModel
import com.alife.domain.main.profile.entity.ProfileInfoEntity
import javax.inject.Inject

interface BaseProfileResponseToProfileEntity : Mapper<ResponseProfileInfoModel, ProfileInfoEntity>

class ProfileResponseToProfileEntity @Inject constructor() : BaseProfileResponseToProfileEntity{
    override fun map(inputModel: ResponseProfileInfoModel) = with(inputModel) {
        ProfileInfoEntity(username, name, country, description, pictureUrl)
    }
}