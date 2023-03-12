package com.alife.domain.registration.usecase.name

import com.alife.domain.core.mapper.ThrowableMapper
import com.alife.domain.core.usecase.AbstractSafeUseCase
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.name.addons.NameRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class NameReadRegStageUseCase @Inject constructor(
    private val registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableMapper<NameRegEntity>,
) : AbstractSafeUseCase<NameRegEntity>(dispatcher, exceptionMapper), BaseNameUseCase.Read {

    override suspend fun readData() = withSafe {
        NameRegEntity(
            registrationRepository.readRegData(NameReadRegEntity())
        )
    }
}