package com.alife.domain.registration.usecase.email

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.RegistrationReadUseCaseBase
import com.alife.domain.registration.usecase.email.entity.EmailRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class EmailReadBaseRegUseCase @Inject constructor(
    registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableMapper<EmailRegEntity>,
) : RegistrationReadUseCaseBase<EmailRegEntity>(registrationRepository, dispatcher, exceptionMapper),
    BaseEmailUseCase.Read {

    override suspend fun readData() = withSafe {
        EmailRegEntity(
            registrationRepository.readRegData(EmailReadRegEntity())
        )
    }
}