package com.alife.data.interceptor.model

import com.google.gson.annotations.SerializedName

class RequestRefreshModel(
    @SerializedName("refreshToken")
    val refreshToken: String
)