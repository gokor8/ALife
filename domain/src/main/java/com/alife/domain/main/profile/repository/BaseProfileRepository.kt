package com.alife.domain.main.profile.repository

import com.alife.domain.main.profile.entity.BasePhotoUriWrapper
import com.alife.domain.main.profile.entity.ProfileInfoEntity

interface BaseProfileRepository {

    suspend fun getPostProfile(username: String): ProfileInfoEntity

    suspend fun getUserInfo(): ProfileInfoEntity

    suspend fun getPhotoBytes(photoUriReader: BasePhotoUriWrapper): ByteArray
}