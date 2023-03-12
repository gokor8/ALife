package com.alife.domain.registration.usecase.email.save_read

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.RegistrationReadUseCaseBaseStage
import com.alife.domain.registration.usecase.email.save_read.entity.BoxEmailRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class EmailReadRegStageUseCase @Inject constructor(
    registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableMapper<BoxEmailRegEntity>,
) : RegistrationReadUseCaseBaseStage<BoxEmailRegEntity>(registrationRepository, dispatcher, exceptionMapper),
    BaseEmailUseCase.Read {

    override suspend fun readData() = withSafe {
        BoxEmailRegEntity(
            registrationRepository.readRegData(EmailReadRegEntity())
        )
    }
}