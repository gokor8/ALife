package com.alife.data.repository.registration.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.repository.registration.net_model.RequestRegistration
import com.alife.domain.registration.usecase.email.send_reg_data.entity.RegDataEntity
import javax.inject.Inject

interface BaseRegDataEntityToRequest : Mapper<RegDataEntity, RequestRegistration>

class RegDataEntityToRequest @Inject constructor() : BaseRegDataEntityToRequest {
    override fun map(inputModel: RegDataEntity) = with(inputModel) {
        RequestRegistration(name, username, birthday, email)
    }
}

