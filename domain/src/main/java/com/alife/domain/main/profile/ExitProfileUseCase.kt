package com.alife.domain.main.profile

import com.alife.domain.core.usecase.AbstractUseCase
import com.alife.domain.registration.repository.BaseTokenCacheRepository
import com.alife.domain.registration.usecase.token.cache.TokenReadEntity
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ExitProfileUseCase @Inject constructor(
    override val dispatcher: CoroutineDispatcher,
    private val tokenRepository: BaseTokenCacheRepository
) : AbstractUseCase() {

    fun exit() {
        tokenRepository.deleteData(TokenReadEntity())
    }
}