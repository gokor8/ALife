package com.alife.domain.registration.usecase.reg_log.email_code

import com.alife.domain.registration.repository.BaseRegCacheRepository
import com.alife.domain.registration.repository.BaseRegistrationRepository
import com.alife.domain.registration.repository.BaseTokenCacheRepository
import com.alife.domain.registration.usecase.reg_log.email.save_read.EmailReadCacheEntity
import com.alife.domain.registration.usecase.token.cache.TokenSaveEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EmailCodeUseCaseResult @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val registrationRepository: BaseRegistrationRepository,
    private val tokenCacheRepository: BaseTokenCacheRepository,
    private val cacheRepository: BaseRegCacheRepository,
) : BaseEmailCodeUseCase {

    override suspend fun sendCode(code: String) = withContext(dispatcher) {
        val email = cacheRepository.readData<String>(EmailReadCacheEntity())

        val tokens = registrationRepository.confirmCode(email, code)

        tokenCacheRepository.saveData(
            TokenSaveEntity(tokens.accessToken, tokens.refreshToken)
        )
    }
}