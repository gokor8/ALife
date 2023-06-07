package com.alife.domain.main.profile.repository

import com.alife.domain.main.profile.entity.BasePhotoUriWrapper
import com.alife.domain.main.profile.entity.ProfileInfoEntity
import com.alife.domain.main.profile.entity.ProfileMainInfoEntity
import java.io.File

interface BaseProfileRepository {

    suspend fun getPostProfile(username: String): ProfileInfoEntity

    suspend fun getUserInfo(): ProfileInfoEntity

    suspend fun getPhotoFile(photoUriReader: BasePhotoUriWrapper): File

    suspend fun saveData(profileData: ProfileMainInfoEntity): ProfileInfoEntity

    suspend fun saveProfileImage(photoUri: BasePhotoUriWrapper)
}