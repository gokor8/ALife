package com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper

import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseFileOutputOptions
import com.alife.domain.main.create_alife.video.entity.VideoPathEntity
import javax.inject.Inject

class VideoStorageToOptions @Inject constructor() : BaseVideoStorageToOptions {
    override fun map(inputModel: VideoPathEntity): BaseFileOutputOptions {
        return BaseFileOutputOptions.Default(inputModel)
    }
}