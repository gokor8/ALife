package com.alife.domain.main.profile

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.main.profile.entity.ProfileInfoEntity
import com.alife.domain.main.profile.repository.BaseProfileRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UserProfileInfoUseCase @Inject constructor(
    override val dispatcher: CoroutineDispatcher,
    private val baseProfileRepository: BaseProfileRepository
) : AbstractUseCase(), BaseUserProfileInfoUseCase {

    override suspend fun getProfileInfo(): ProfileInfoEntity {
        return baseProfileRepository.getUserInfo()
    }
}