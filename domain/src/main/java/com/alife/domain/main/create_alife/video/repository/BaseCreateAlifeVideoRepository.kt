package com.alife.domain.main.create_alife.video.repository

import com.alife.domain.main.create_alife.video.entity.BaseVideoStorageEntity

interface BaseCreateAlifeVideoRepository {

    fun getVideoStorageModel(): BaseVideoStorageEntity
}