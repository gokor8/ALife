package com.alife.domain.registration.usecase.email.send_reg_data

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.AbstractSafeUseCaseResult
import com.alife.domain.core.usecase.UseCaseResult
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.usecase.email.send_reg_data.entity.RegDataEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SendRegDataUseCaseResult @Inject constructor(
    dispatcher: CoroutineDispatcher,
    exceptionMapper: ThrowableUCMapper<Nothing>,
    private val regDataFacadeUseCase: BaseRegDataFacadeUseCase,
    private val registrationRepository: BaseRegistrationRepository,
) : AbstractSafeUseCaseResult<Nothing>(dispatcher, exceptionMapper),
    BaseSendRegDataUseCase {

    override fun onSuccess(result: Nothing): UseCaseResult.BaseSuccess<Nothing> {
        return UseCaseResult.EmptySuccess()
    }

    override suspend fun sendRegData() = withSafe {
        registrationRepository.sendRegData(
            regDataFacadeUseCase.fillRegData()
        )
    }
}