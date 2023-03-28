package com.alife.domain.main.home.child.child_world

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.main.home.child.ProfileCardUseCase
import com.alife.domain.main.home.child.ProfileUseCaseEntity
import com.alife.domain.main.home.child.mapper.BaseThrowToProfileEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class WorldProfileCardUC @Inject constructor(
    dispatcher: CoroutineDispatcher,
    throwableMapper: BaseThrowToProfileEntity
) : ProfileCardUseCase(dispatcher, throwableMapper) {

    override suspend fun getProfileCards(): UseCaseResult<ProfileUseCaseEntity> {
        return withSafe { ProfileUseCaseEntity(emptyList()) }
    }
}