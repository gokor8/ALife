package com.alife.data.repository.main.map.model

import com.google.gson.annotations.SerializedName

class MapPostDataModel(
    @SerializedName("username")
    val username: String,
    @SerializedName("creationDate")
    val creationDate: Long,
    @SerializedName("firstPhoto")
    val firstPhoto: String?,
    @SerializedName("video")
    val video: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
) {

    fun getLatLng(): Pair<Double, Double> {
        return Pair(
            latitude ?: throw java.lang.NumberFormatException(),
            longitude ?: throw java.lang.NumberFormatException()
        )
    }
}