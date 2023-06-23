package com.alife.domain.main.create_alife.picture.repository

import com.alife.domain.main.create_alife.picture.entity.ImageReadEntity
import com.alife.domain.main.create_alife.picture.entity.SaveImageEntity

interface BaseCreateAlifeRepository {

    suspend fun saveToFile(saveImageEntity: SaveImageEntity)

    suspend fun readFromFile(imageReadEntity: ImageReadEntity): ByteArray
}