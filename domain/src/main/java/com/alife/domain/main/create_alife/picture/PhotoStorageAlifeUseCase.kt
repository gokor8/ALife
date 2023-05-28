package com.alife.domain.main.create_alife.picture

import com.alife.domain.main.create_alife.picture.repository.BaseCreateAlifePhotoRepository
import javax.inject.Inject

class PhotoStorageAlifeUseCase @Inject constructor(
    private val repository: BaseCreateAlifePhotoRepository
) : BasePhotoStorageAlifeUseCase {

    override suspend fun getPictures() = repository.readPhotoUrls()
}