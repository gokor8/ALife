package com.alife.domain.registration.usecase.token

interface TokenStateEntity {

    class Empty : TokenStateEntity

    class Fill(
        val authorizationToken: String,
        val refreshToken: String
    ) : TokenStateEntity
}