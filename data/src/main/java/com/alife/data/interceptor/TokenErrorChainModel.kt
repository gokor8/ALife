package com.alife.data.interceptor

import com.alife.domain.registration.usecase.token.TokenStateEntity
import okhttp3.Interceptor.Chain

data class TokenErrorChainModel(
    val tokenStateEntity: TokenStateEntity.Fill,
    val chain: Chain
)