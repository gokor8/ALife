package com.alife.data.repository.registration.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.data_source.model.CacheModel
import com.alife.domain.registration.entity.RegistrationEntity

interface BaseRegEntityToWriteRegModel : Mapper<RegistrationEntity<*>, CacheModel.Write<*>>