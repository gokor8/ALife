package com.alife.domain.main.map

interface BaseMapRepository {

    suspend fun getMapPostList(): List<MapPostEntity>
}