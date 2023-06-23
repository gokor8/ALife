package com.alife.data.repository.main.profile.model

import com.google.gson.annotations.SerializedName

class RequestProfileSaveData(
    @SerializedName("username")
    val username: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String
)