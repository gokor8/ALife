package com.alife.data.repository.main.create_alife.picture.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.repository.main.create_alife.file_model_base.BaseReadFileModel
import com.alife.domain.main.create_alife.picture.entity.ReadImageEntity

interface BaseEntityToReadModel : Mapper<ReadImageEntity, BaseReadFileModel>