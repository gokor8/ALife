package com.alife.domain.main.create_alife.picture.repository

import com.alife.domain.main.create_alife.picture.entity.ReadImageEntity
import com.alife.domain.main.create_alife.picture.entity.SaveImageEntity

interface BaseCreateAlifeRepository {

    suspend fun saveToFile(saveImageEntity: SaveImageEntity)

    suspend fun readFromFile(readImageEntity: ReadImageEntity): ByteArray
}