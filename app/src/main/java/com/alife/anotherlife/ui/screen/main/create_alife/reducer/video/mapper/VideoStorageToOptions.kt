package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseFileOutputOptions
import com.alife.data.repository.main.create_alife.video.entity.VideoStorageEntity
import com.alife.domain.core.MappingException
import com.alife.domain.main.create_alife.video.entity.BaseVideoStorageEntity
import javax.inject.Inject

class VideoStorageToOptions @Inject constructor() : BaseVideoStorageToOptions {
    override fun map(inputModel: BaseVideoStorageEntity): BaseFileOutputOptions {
        return if(inputModel is VideoStorageEntity)
            BaseFileOutputOptions.Default(inputModel)
        else
            throw MappingException()
    }
}