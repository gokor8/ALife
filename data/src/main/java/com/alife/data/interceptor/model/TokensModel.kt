package com.alife.data.interceptor.model

import com.alife.domain.registration.usecase.token.BaseTokensModel

class TokensModel(
    val authorizationToken: String,
    val refreshToken: String
) : BaseTokensModel