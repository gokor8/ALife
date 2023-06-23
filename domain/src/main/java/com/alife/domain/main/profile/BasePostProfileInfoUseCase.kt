package com.alife.domain.main.profile

import com.alife.domain.main.profile.entity.ProfileInfoEntity

interface BasePostProfileInfoUseCase {
    suspend fun getUserInfo(username: String): ProfileInfoEntity
}