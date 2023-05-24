package com.alife.domain.registration.usecase.token.cache

import com.alife.core.mapper.Mapper
import com.alife.domain.registration.repository.BaseTokenCacheRepository
import javax.inject.Inject

class TokensUseCase @Inject constructor(
    private val cacheRepository: BaseTokenCacheRepository,
    private val readMapper: Mapper<BaseTokensModel, TokenStateEntity>
) : BaseTokensUseCase {

    override suspend fun saveTokens(authorizationToken: String, refreshToken: String) {
        cacheRepository.saveData(TokenSaveEntity(authorizationToken, refreshToken))
    }

    override suspend fun getTokens() = try {
        readMapper.map(cacheRepository.readData(TokenReadEntity()))
    } catch (e: Throwable) {
        TokenStateEntity.Empty()
    }

    override suspend fun deleteTokens() {
        cacheRepository.deleteData(TokenReadEntity())
    }
}