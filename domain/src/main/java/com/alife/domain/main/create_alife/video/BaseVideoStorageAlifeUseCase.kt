package com.alife.domain.main.create_alife.video

import com.alife.domain.main.create_alife.video.entity.VideoPathEntity

interface BaseVideoStorageAlifeUseCase {

    fun getVideoStorageEntity(): VideoPathEntity
}