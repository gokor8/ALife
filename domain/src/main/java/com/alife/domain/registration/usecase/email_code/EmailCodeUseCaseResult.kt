package com.alife.domain.registration.usecase.email_code

import com.alife.domain.core.mapper.ThrowableUCMapper
import com.alife.domain.core.usecase.AbstractSafeUseCaseResult
import com.alife.domain.registration.repository.BaseRegistrationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EmailCodeUseCaseResult @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val registrationRepository: BaseRegistrationRepository
) : BaseEmailCodeUseCase {

    override suspend fun sendCode(code: String) = withContext(dispatcher) {
        registrationRepository.confirmCode(code)
    }
}