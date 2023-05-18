package com.alife.data.repository.registration.net_model

import com.google.gson.annotations.SerializedName

class RequestRegistration(
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("email")
    val email: String
)