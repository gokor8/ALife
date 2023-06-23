package com.alife.domain.main.profile

import com.alife.domain.main.profile.entity.ProfileInfoEntity

interface BaseUserProfileInfoUseCase {
    suspend fun getProfileInfo(): ProfileInfoEntity
}