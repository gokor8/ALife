package com.alife.domain.main.create_alife.video

import com.alife.domain.main.create_alife.video.entity.VideoStorageEntity

interface BaseVideoStorageAlifeUseCase {

    fun getVideoStorageEntity(): VideoStorageEntity
}