package com.alife.domain.registration.usecase.email.save_read

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.RegistrationReadRegStageUC
import com.alife.domain.registration.usecase.email.save_read.entity.EmailReadBoxEntity
import com.alife.domain.registration.usecase.email.save_read.entity.EmailRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class EmailReadRegStageUC @Inject constructor(
    registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableUCMapper<EmailRegEntity>,
) : RegistrationReadRegStageUC<EmailRegEntity>(registrationRepository, dispatcher, exceptionMapper),
    BaseEmailUseCase.Read, BaseEmailUseCase.ReadBox {

    override suspend fun readData() = withSafe {
        EmailRegEntity(
            registrationRepository.readRegData(EmailReadCacheEntity())
        )
    }

    override suspend fun readAndBox() = EmailReadBoxEntity(readData())
}