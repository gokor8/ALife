package com.alife.anotherlife.ui.screen.main.create_alife.reducer_video

import androidx.camera.video.FileOutputOptions
import com.alife.anotherlife.ui.screen.main.create_alife.model.camera.video.options.BaseFileOutputOptions
import com.alife.anotherlife.ui.screen.main.create_alife.reducer.video.mapper.BaseVideoStorageToOptions
import com.alife.domain.main.create_alife.video.entity.BaseVideoStorageEntity

class FakeVideoStorageToOptions : BaseVideoStorageToOptions {
    override fun map(inputModel: BaseVideoStorageEntity): BaseFileOutputOptions {
        return object : BaseFileOutputOptions {
            override fun options(): FileOutputOptions {
                TODO("Not yet implemented")
            }
        }
    }
}