package com.alife.data.repository.registration.net_model

import com.google.gson.annotations.SerializedName

class RequestCode(
    @SerializedName("email")
    val email: String,
    @SerializedName("code")
    val code: String
)