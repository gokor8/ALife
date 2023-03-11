package com.alife.domain.registration.usecase.username

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.core.usecase.AbstractSafeUseCase
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.username.addons.UsernameRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UsernameReadUseCase @Inject constructor(
    private val registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableMapper<UsernameRegEntity>,
) : AbstractSafeUseCase<UsernameRegEntity>(dispatcher, exceptionMapper), BaseUsernameUseCase.Read {

    override suspend fun readName() = withSafe {
        UsernameRegEntity(
            registrationRepository.readRegData(UsernameReadRegEntity())
        )
    }
}