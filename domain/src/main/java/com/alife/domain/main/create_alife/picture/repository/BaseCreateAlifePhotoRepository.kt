package com.alife.domain.main.create_alife.picture.repository

import com.alife.domain.main.create_alife.picture.entity.PhotoPathEntity

interface BaseCreateAlifePhotoRepository {
    suspend fun readPhotoUrls(): PhotoPathEntity
}