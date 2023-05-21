package com.alife.domain.registration.usecase.birthday

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.registration.repository.BaseRegCacheRepository
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.RegistrationReadRegStageUC
import com.alife.domain.registration.usecase.birthday.entity.BirthdayReadBoxEntity
import com.alife.domain.registration.usecase.birthday.entity.BirthdayRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class BirthdayReadRegStageUC @Inject constructor(
    registrationRepository: BaseRegCacheRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableUCMapper<BirthdayRegEntity>,
) : RegistrationReadRegStageUC<BirthdayRegEntity>(
    registrationRepository,
    dispatcher,
    exceptionMapper
), BaseBirthdayUseCase.Read, BaseBirthdayUseCase.ReadBox {

    override suspend fun readData() = withSafe {
        BirthdayRegEntity(registrationRepository.readData(BirthdayReadCacheEntity()))
    }

    override suspend fun readAndBox() = BirthdayReadBoxEntity(readData())
}