package com.alife.data.interceptor.model

import com.alife.domain.registration.usecase.token.cache.BaseTokensModel
import com.google.gson.annotations.SerializedName

class TokensModel(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("refreshToken")
    val refreshToken: String
) : BaseTokensModel {

    override fun toString(): String = "$accessToken \r\n $refreshToken"
}