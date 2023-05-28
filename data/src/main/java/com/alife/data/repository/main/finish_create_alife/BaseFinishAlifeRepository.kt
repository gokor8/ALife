package com.alife.data.repository.main.finish_create_alife

interface BaseFinishAlifeRepository {

    suspend fun uploadPhoto()

    suspend fun uploadVideo()
}