package com.alife.domain.registration.usecase.birthday

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.ReadBoxRegEntity
import com.alife.domain.registration.usecase.base.RegistrationReadRegStageUC
import com.alife.domain.registration.usecase.birthday.entity.BirthdayReadBoxEntity
import com.alife.domain.registration.usecase.birthday.entity.BirthdayRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class BirthdayReadRegStageUC @Inject constructor(
    registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableUCMapper<BirthdayRegEntity>,
) : RegistrationReadRegStageUC<BirthdayRegEntity>(
    registrationRepository,
    dispatcher,
    exceptionMapper
), BaseBirthdayUseCase.Read, BaseBirthdayUseCase.ReadBox {

    override suspend fun readData() = withSafe {
        BirthdayRegEntity(
            registrationRepository.readRegData(BirthdayReadRegEntity())
        )
    }

    override suspend fun readAndBox() = BirthdayReadBoxEntity(readData())
}