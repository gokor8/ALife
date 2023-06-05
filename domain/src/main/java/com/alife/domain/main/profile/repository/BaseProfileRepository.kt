package com.alife.domain.main.profile.repository

import com.alife.domain.main.profile.entity.ProfileInfoEntity

interface BaseProfileRepository {

    suspend fun getPostProfile(username: String): ProfileInfoEntity

    suspend fun getUserInfo(): ProfileInfoEntity
}