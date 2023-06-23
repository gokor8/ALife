package com.alife.domain.main.create_alife.video.repository

import com.alife.domain.main.create_alife.video.entity.VideoPathEntity

interface BaseCreateAlifeVideoRepository {

    fun getVideoUrl(): VideoPathEntity

    fun getRawVideoUrl(): VideoPathEntity
}