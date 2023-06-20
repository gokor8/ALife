package com.alife.domain.main.finish_create_alife

interface BaseFinishAlifeRepository {

    suspend fun uploadPhoto(locationEntity: BaseLocationEntity)

    suspend fun uploadVideo(locationEntity: BaseLocationEntity)
}