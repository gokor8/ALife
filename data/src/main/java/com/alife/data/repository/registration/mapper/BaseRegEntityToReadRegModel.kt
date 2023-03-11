package com.alife.data.repository.registration.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.data_source.model.CacheModel
import com.alife.domain.registration.core.entity.RegInputEntity

interface BaseRegEntityToReadRegModel : Mapper<RegInputEntity<*>, CacheModel.Read<*>>