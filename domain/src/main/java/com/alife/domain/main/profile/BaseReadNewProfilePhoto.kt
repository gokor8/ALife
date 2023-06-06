package com.alife.domain.main.profile

import com.alife.core.usecase.UseCase
import com.alife.domain.main.profile.entity.BasePhotoUriWrapper

interface BaseReadNewProfilePhoto : UseCase {

    suspend fun getPhoto(photoUriReader: BasePhotoUriWrapper): ByteArray
}