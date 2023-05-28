package com.alife.domain.registration.usecase.token.cache

interface TokenStateEntity {

    class Empty : TokenStateEntity

    class Fill(
        val accessToken: String,
        val refreshToken: String
    ) : TokenStateEntity
}