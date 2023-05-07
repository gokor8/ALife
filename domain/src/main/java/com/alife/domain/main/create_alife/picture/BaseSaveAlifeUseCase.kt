package com.alife.domain.main.create_alife.picture

import com.alife.domain.main.create_alife.picture.entity.SaveImageEntity

interface BaseSaveAlifeUseCase {

    suspend fun saveImage(saveImageEntity: SaveImageEntity)
}