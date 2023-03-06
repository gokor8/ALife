package com.alife.data.repository.registration.model

import com.alife.core.mapper.Mapper
import com.alife.domain.registration.entity.RegistrationEntity

interface RegEntityToRegModel : Mapper<RegistrationEntity, RegistrationModel>