package com.alife.domain.registration.usecase.email.send_reg_data

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.AbstractSafeUseCase
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.email.send_reg_data.entity.RegDataEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SendRegDataUseCase @Inject constructor(
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableUCMapper<RegDataEntity>,
    private val regDataFacadeUseCase: BaseRegDataFacadeUseCase,
    private val registrationRepository: BaseRegistrationRepository
) : AbstractSafeUseCase<RegDataEntity>(dispatcher, exceptionMapper), BaseSendRegDataUseCase {

    override suspend fun sendRegData(): UseCaseResult<RegDataEntity> = withSafe {
        registrationRepository.sendRegData(
            regDataFacadeUseCase.fillRegData()
        )
    }
}