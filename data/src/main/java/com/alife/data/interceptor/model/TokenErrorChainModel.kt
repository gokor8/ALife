package com.alife.data.interceptor.model

import okhttp3.Interceptor.Chain
import okhttp3.Request

data class TokenErrorChainModel(
    val refreshToken: String,
    val chain: Chain,
    val request: Request
)