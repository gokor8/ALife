package com.alife.data.repository.main.map.model

import com.alife.data.repository.main.home.child.model.BasePostResponse
import com.google.gson.annotations.SerializedName

class MapPostDataModel(
    username: String,
    creationDate: Long,
    profilePhoto: String,
    firstPhoto: String?,
    secondPhoto: String?,
    video: String?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
) : BasePostResponse(username, creationDate, profilePhoto, firstPhoto, secondPhoto, video) {

    fun getLatLng(): Pair<Double, Double> {
        return Pair(
            latitude ?: throw java.lang.NumberFormatException(),
            longitude ?: throw java.lang.NumberFormatException()
        )
    }
}