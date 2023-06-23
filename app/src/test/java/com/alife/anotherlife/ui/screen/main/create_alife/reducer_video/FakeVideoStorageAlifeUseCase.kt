package com.alife.anotherlife.ui.screen.main.create_alife.reducer_video

import com.alife.domain.main.create_alife.video.BaseVideoStorageAlifeUseCase
import com.alife.domain.main.create_alife.video.entity.BaseVideoStorageEntity

class FakeVideoStorageAlifeUseCase : BaseVideoStorageAlifeUseCase {
    override fun getVideoStorageEntity(): BaseVideoStorageEntity {
        return object : BaseVideoStorageEntity {}
    }
}