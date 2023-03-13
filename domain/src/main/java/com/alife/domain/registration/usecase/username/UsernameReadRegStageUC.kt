package com.alife.domain.registration.usecase.username

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.RegistrationReadRegStageUC
import com.alife.domain.registration.usecase.username.addons.UsernameRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UsernameReadRegStageUC @Inject constructor(
    registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableUCMapper<UsernameRegEntity>,
) : RegistrationReadRegStageUC<UsernameRegEntity>(
    registrationRepository,
    dispatcher,
    exceptionMapper
), BaseUsernameUseCase.Read {

    override suspend fun readData() = withSafe {
        UsernameRegEntity(
            registrationRepository.readRegData(UsernameReadRegEntity())
        )
    }

}