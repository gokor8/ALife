package com.alife.domain.main.profile

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.main.profile.entity.BasePhotoUriWrapper
import com.alife.domain.main.profile.entity.ProfileMainInfoEntity
import com.alife.domain.main.profile.repository.BaseProfileRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SaveProfileDataUseCase @Inject constructor(
    override val dispatcher: CoroutineDispatcher,
    private val profileRepository: BaseProfileRepository
) : AbstractUseCase(), BaseSaveProfileDataUseCase {

    override suspend fun saveData(profileData: ProfileMainInfoEntity) = withIO {
        profileRepository.saveData(profileData)
    }

    override suspend fun saveProfileImage(photoUri: BasePhotoUriWrapper) = withIO {
        profileRepository.saveProfileImage(photoUri)
    }
}