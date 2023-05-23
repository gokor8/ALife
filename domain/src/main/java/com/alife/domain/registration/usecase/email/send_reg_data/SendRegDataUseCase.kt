package com.alife.domain.registration.usecase.email.send_reg_data

import com.alife.domain.registration.repository.BaseRegistrationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SendRegDataUseCase @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val regDataFacadeUseCase: BaseRegDataFacadeUseCase,
    private val registrationRepository: BaseRegistrationRepository,
) : BaseSendRegDataUseCase {

    override suspend fun sendRegData() = withContext(dispatcher) {
        registrationRepository.sendRegData(
            regDataFacadeUseCase.fillRegData()
        )
    }
}