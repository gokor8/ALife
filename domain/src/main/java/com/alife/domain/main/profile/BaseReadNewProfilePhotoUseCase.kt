package com.alife.domain.main.profile

import com.alife.core.usecase.UseCase
import com.alife.domain.main.profile.entity.BasePhotoUriWrapper
import java.io.File

interface BaseReadNewProfilePhotoUseCase : UseCase {

    suspend fun getPhoto(photoUriReader: BasePhotoUriWrapper): File
}