package com.alife.domain.main.create_alife.video

import com.alife.domain.main.create_alife.video.entity.BaseVideoStorageEntity

interface BaseVideoStorageAlifeUseCase {

    fun getVideoStorageEntity(): BaseVideoStorageEntity
}