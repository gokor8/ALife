package com.alife.domain.registration.usecase.username

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.RegistrationReadUseCaseBase
import com.alife.domain.registration.usecase.username.addons.UsernameRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class UsernameReadUseCaseBase @Inject constructor(
    registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableMapper<UsernameRegEntity>,
) : RegistrationReadUseCaseBase<UsernameRegEntity>(registrationRepository, dispatcher, exceptionMapper),
    BaseUsernameUseCase.Read {

    override suspend fun readData(): UsernameRegEntity = withSafe {
        UsernameRegEntity(
            registrationRepository.readRegData(UsernameReadRegEntity())
        )
    }

}