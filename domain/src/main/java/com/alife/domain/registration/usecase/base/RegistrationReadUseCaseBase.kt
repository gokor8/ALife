package com.alife.domain.registration.usecase.base

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.core.usecase.AbstractSafeUseCase
import com.alife.domain.registration.core.entity.BoxerRegEntity
import com.alife.domain.registration.repository.BaseRegistrationRepository
import kotlinx.coroutines.CoroutineDispatcher

abstract class RegistrationReadUseCaseBase<M : BoxerRegEntity>(
    protected val registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableMapper<M>,
) : AbstractSafeUseCase<M>(dispatcher, exceptionMapper), BaseBaseRegUseCase.Read<M>