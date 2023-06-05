package com.alife.data.repository.main.profile

import com.google.gson.annotations.SerializedName

class ResponseProfileInfoModel(
    @SerializedName("username")
    val username: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("pictureUrl")
    val pictureUrl: String
)