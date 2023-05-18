package com.alife.data.repository.registration.net_model

import com.google.gson.annotations.SerializedName


class ResponseErrorRegistration(
    @SerializedName("message")
    val errorMessage: String
)