package com.alife.domain.main.profile

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.main.profile.entity.ProfileInfoEntity
import com.alife.domain.main.profile.repository.BaseProfileRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class PostProfileInfoUseCase @Inject constructor(
    override val dispatcher: CoroutineDispatcher,
    private val baseProfileRepository: BaseProfileRepository
) : AbstractUseCase(), BasePostProfileInfoUseCase {

    override suspend fun getUserInfo(username: String): ProfileInfoEntity = withIO {
        baseProfileRepository.getPostProfile(username)
    }
}