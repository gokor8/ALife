package com.alife.domain.registration.usecase.username

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.RegistrationReadUseCaseBaseStage
import com.alife.domain.registration.usecase.username.addons.UsernameRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UsernameReadRegStageUseCase @Inject constructor(
    registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableMapper<UsernameRegEntity>,
) : RegistrationReadUseCaseBaseStage<UsernameRegEntity>(registrationRepository, dispatcher, exceptionMapper),
    BaseUsernameUseCase.Read {

    override suspend fun readData(): UsernameRegEntity = withSafe {
        UsernameRegEntity(
            registrationRepository.readRegData(UsernameReadRegEntity())
        )
    }

}