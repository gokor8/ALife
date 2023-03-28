package com.alife.domain.registration.usecase.email.send_reg_data

import com.alife.domain.core.usecase.AbstractSafeUseCase
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.email.send_reg_data.mapper.BaseThrowToRegData
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SendRegDataUseCase @Inject constructor(
    dispatcher: CoroutineDispatcher,
    exceptionMapper: BaseThrowToRegData,
    private val regDataFacadeUseCase: BaseRegDataFacadeUseCase,
    private val registrationRepository: BaseRegistrationRepository,
) : AbstractSafeUseCase.Empty(dispatcher, exceptionMapper), BaseSendRegDataUseCase {

    override suspend fun sendRegData() = withSafe {
        registrationRepository.sendRegData(
            regDataFacadeUseCase.fillRegData()
        )
    }
}