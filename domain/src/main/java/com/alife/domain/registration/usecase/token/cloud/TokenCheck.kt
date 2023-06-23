package com.alife.domain.registration.usecase.token.cloud

import com.alife.domain.registration.repository.BaseRegistrationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TokenCheckUseCase @Inject constructor(
    private val registrationRepository: BaseRegistrationRepository
) : BaseTokenCheckUseCase {

    override suspend fun tokensCheck() = withContext(Dispatchers.IO) {
        registrationRepository.checkToken()
    }
}