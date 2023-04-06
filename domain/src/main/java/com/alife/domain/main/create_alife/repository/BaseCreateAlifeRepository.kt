package com.alife.domain.main.create_alife.repository

import com.alife.domain.main.create_alife.entity.ReadImageEntity
import com.alife.domain.main.create_alife.entity.SaveImageEntity

interface BaseCreateAlifeRepository {

    suspend fun saveToFile(saveImageEntity: SaveImageEntity)

    suspend fun readFromFile(readImageEntity: ReadImageEntity): ByteArray
}