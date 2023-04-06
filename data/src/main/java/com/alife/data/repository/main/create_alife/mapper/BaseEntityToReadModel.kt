package com.alife.data.repository.main.create_alife.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.repository.main.create_alife.model.base.BaseReadFileModel
import com.alife.domain.main.create_alife.entity.ReadImageEntity

interface BaseEntityToReadModel : Mapper<ReadImageEntity, BaseReadFileModel>