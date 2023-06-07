package com.alife.domain.main.profile

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.main.profile.entity.BasePhotoUriWrapper
import com.alife.domain.main.profile.repository.BaseProfileRepository
import kotlinx.coroutines.CoroutineDispatcher
import java.io.File
import javax.inject.Inject

class ReadNewProfilePhotoUseCase @Inject constructor(
    override val dispatcher: CoroutineDispatcher,
    private val profileRepository: BaseProfileRepository
) : AbstractUseCase(), BaseReadNewProfilePhotoUseCase {

    override suspend fun getPhoto(photoUriReader: BasePhotoUriWrapper): File = withIO {
        profileRepository.getPhotoFile(photoUriReader)
    }
}