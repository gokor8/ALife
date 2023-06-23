package com.alife.domain.registration.usecase.reg_log.name

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.AbstractSafeUseCaseResult
import com.alife.domain.registration.repository.BaseRegCacheRepository
import com.alife.domain.registration.usecase.reg_log.name.addons.NameReadBoxEntity
import com.alife.domain.registration.usecase.reg_log.name.addons.NameRegEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class NameReadRegStageUC @Inject constructor(
    private val registrationRepository: BaseRegCacheRepository,
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableUCMapper<NameRegEntity>,
) : AbstractSafeUseCaseResult<NameRegEntity>(dispatcher, exceptionMapper),
    BaseNameUseCase.Read, BaseNameUseCase.ReadBox {

    override suspend fun readData() = withSafe {
        NameRegEntity(registrationRepository.readData(NameReadCacheEntity()))
    }

    override suspend fun readAndBox() = NameReadBoxEntity(readData())
}