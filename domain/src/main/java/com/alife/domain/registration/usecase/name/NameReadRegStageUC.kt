package com.alife.domain.registration.usecase.name

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.AbstractSafeUseCaseResult
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.name.addons.NameReadBoxEntity
import com.alife.domain.registration.usecase.name.addons.NameRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class NameReadRegStageUC @Inject constructor(
    private val registrationRepository: BaseRegistrationRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableUCMapper<NameRegEntity>,
) : AbstractSafeUseCaseResult<NameRegEntity>(dispatcher, exceptionMapper),
    BaseNameUseCase.Read, BaseNameUseCase.ReadBox {

    override suspend fun readData() = withSafe {
        NameRegEntity(
            registrationRepository.readRegData(NameReadRegEntity())
        )
    }

    override suspend fun readAndBox() = NameReadBoxEntity(readData())
}