package com.alife.domain.main

interface BaseMyPostUseCase {

    suspend fun isHavePostToday(): Boolean
}