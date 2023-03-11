package com.alife.domain.registration.usecase.birthday

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.base.RegistrationReadUseCaseBase
import com.alife.domain.registration.usecase.birthday.entity.BirthdayRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class BirthdayReadBaseRegUseCase @Inject constructor(
    registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableMapper<BirthdayRegEntity>,
) : RegistrationReadUseCaseBase<BirthdayRegEntity>(registrationRepository, dispatcher, exceptionMapper),
    BaseBirthdayUseCase.Read {

    override suspend fun readData() = withSafe {
        BirthdayRegEntity(
            registrationRepository.readRegData(BirthdayReadRegEntity())
        )
    }
}