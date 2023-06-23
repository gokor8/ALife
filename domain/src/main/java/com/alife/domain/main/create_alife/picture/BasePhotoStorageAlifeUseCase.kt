package com.alife.domain.main.create_alife.picture

import com.alife.domain.main.create_alife.picture.entity.PhotoPathEntity

interface BasePhotoStorageAlifeUseCase {

    suspend fun getPictures(): PhotoPathEntity
}