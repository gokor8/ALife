package com.alife.domain.main.profile

import com.alife.core.usecase.UseCase
import com.alife.domain.main.profile.entity.BasePhotoUriWrapper
import com.alife.domain.main.profile.entity.ProfileInfoEntity
import com.alife.domain.main.profile.entity.ProfileMainInfoEntity
import java.io.File

interface BaseSaveProfileDataUseCase : UseCase {

    suspend fun saveData(profileData: ProfileMainInfoEntity)
    suspend fun saveProfileImage(photoUri: BasePhotoUriWrapper): File
}