package com.alife.domain.main.home.child

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.AbstractSafeUseCaseResult
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

abstract class ProfileCardUseCase @Inject constructor(
    dispatcher: CoroutineDispatcher,
    throwableMapper: ThrowableUCMapper<ProfileUseCaseEntity>
) : AbstractSafeUseCaseResult<ProfileUseCaseEntity>(
    dispatcher,
    throwableMapper
), BaseProfileCardUseCase