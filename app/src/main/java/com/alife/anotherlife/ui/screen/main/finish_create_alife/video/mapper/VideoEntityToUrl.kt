package com.alife.anotherlife.ui.screen.main.finish_create_alife.video.mapper

import com.alife.core.mapper.Mapper
import com.alife.data.repository.main.create_alife.video.entity.VideoStorageEntity
import com.alife.domain.core.MappingException
import com.alife.domain.main.create_alife.video.entity.BaseVideoStorageEntity
import javax.inject.Inject

interface BaseVideoEntityToUrl : Mapper<BaseVideoStorageEntity, String>

class VideoEntityToUrl @Inject constructor() : BaseVideoEntityToUrl {
    override fun map(inputModel: BaseVideoStorageEntity): String {
        return if(inputModel is VideoStorageEntity)
            inputModel.videoFile.absolutePath
        else
            throw MappingException()
    }
}