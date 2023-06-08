package com.alife.data.repository.main.create_alife.picture.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.core.file_model_base.BaseReadFileModel
import com.alife.domain.main.create_alife.picture.entity.ImageReadEntity

interface BaseEntityToReadModel : Mapper<ImageReadEntity, BaseReadFileModel>