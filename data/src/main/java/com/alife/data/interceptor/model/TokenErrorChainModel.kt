package com.alife.data.interceptor.model

import okhttp3.Interceptor.Chain

data class TokenErrorChainModel(val refreshToken: String, val chain: Chain)