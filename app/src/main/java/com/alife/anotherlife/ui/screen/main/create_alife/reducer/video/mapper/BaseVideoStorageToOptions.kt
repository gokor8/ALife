package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseFileOutputOptions
import com.alife.core.mapper.Mapper
import com.alife.domain.main.create_alife.video.entity.BaseVideoStorageEntity

interface BaseVideoStorageToOptions : Mapper<BaseVideoStorageEntity, BaseFileOutputOptions>