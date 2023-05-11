package com.alife.data.repository.main.create_alife.picture.mapper

import com.alife.data.repository.main.create_alife.file_model_base.BaseSaveFileModel
import com.alife.domain.core.mapper.LowLayerMapper
import com.alife.domain.main.create_alife.picture.entity.SaveImageEntity

interface BaseEntityToSaveModel : LowLayerMapper<SaveImageEntity, BaseSaveFileModel>