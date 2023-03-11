package com.alife.domain.registration.usecase.birthday

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.core.usecase.AbstractSafeUseCase
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.birthday.entity.BirthdayRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class BirthdayReadRegUseCase @Inject constructor(
    private val registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableMapper<BirthdayRegEntity>,
) : AbstractSafeUseCase<BirthdayRegEntity>(dispatcher, exceptionMapper), BaseBirthdayUseCase.Read {

    override suspend fun readBirthday() = withSafe {
        BirthdayRegEntity(
            registrationRepository.readRegData(BirthdayReadRegEntity())
        )
    }
}