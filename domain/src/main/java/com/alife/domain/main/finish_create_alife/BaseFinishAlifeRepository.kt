package com.alife.domain.main.finish_create_alife

interface BaseFinishAlifeRepository {

    suspend fun uploadPhoto()

    suspend fun uploadVideo()
}