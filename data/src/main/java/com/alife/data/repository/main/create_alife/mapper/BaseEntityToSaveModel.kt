package com.alife.data.repository.main.create_alife.mapper

import com.alife.data.repository.main.create_alife.model.base.BaseSaveFileModel
import com.alife.domain.core.mapper.LowLayerMapper
import com.alife.domain.main.create_alife.entity.SaveImageEntity

interface BaseEntityToSaveModel : LowLayerMapper<SaveImageEntity, BaseSaveFileModel>