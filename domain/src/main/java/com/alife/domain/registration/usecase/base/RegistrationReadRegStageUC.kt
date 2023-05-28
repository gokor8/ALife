package com.alife.domain.registration.usecase.base

import com.alife.core.usecase.UseCaseEntity
import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.core.usecase.AbstractSafeUseCaseResult
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.repository.BaseRegCacheRepository
import kotlinx.coroutines.CoroutineDispatcher

abstract class RegistrationReadRegStageUC<M : UseCaseEntity>(
    protected val registrationRepository: BaseRegCacheRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableMapper<UseCaseResult<M>>
) : AbstractSafeUseCaseResult<M>(dispatcher, exceptionMapper), BaseRegStageUseCase.Read<M>