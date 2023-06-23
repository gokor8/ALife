package com.alife.domain.registration.usecase.reg_log.email.save_read

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.registration.repository.BaseRegCacheRepository
import com.alife.domain.registration.usecase.base.RegistrationReadRegStageUC
import com.alife.domain.registration.usecase.reg_log.email.save_read.entity.EmailReadBoxEntity
import com.alife.domain.registration.usecase.reg_log.email.save_read.entity.EmailRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class EmailReadRegStageUC @Inject constructor(
    registrationRepository: BaseRegCacheRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableUCMapper<EmailRegEntity>,
) : RegistrationReadRegStageUC<EmailRegEntity>(registrationRepository, dispatcher, exceptionMapper),
    BaseEmailUseCase.Read, BaseEmailUseCase.ReadBox {

    override suspend fun readData() = withSafe {
        EmailRegEntity(registrationRepository.readData(EmailReadCacheEntity()))
    }

    override suspend fun readAndBox() = EmailReadBoxEntity(readData())
}