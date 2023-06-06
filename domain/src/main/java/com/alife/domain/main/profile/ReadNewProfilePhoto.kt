package com.alife.domain.main.profile

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.main.profile.entity.BasePhotoUriWrapper
import com.alife.domain.main.profile.repository.BaseProfileRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ReadNewProfilePhoto @Inject constructor(
    override val dispatcher: CoroutineDispatcher,
    private val profileRepository: BaseProfileRepository
) : AbstractUseCase(), BaseReadNewProfilePhoto {

    override suspend fun getPhoto(photoUriReader: BasePhotoUriWrapper): ByteArray = withIO {
        profileRepository.getPhotoBytes(photoUriReader)
    }
}